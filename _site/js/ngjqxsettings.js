/* ngJqxsettings.js
 * Benedict Brown
 * June 2014
 *
 * Based on sample AngularJS integration code from jqwidgets.com
 *
 * Uses angular to automatically instatiate jqWidgets based on tag attributes.
 * Angular scope variables are monitored and changes are passed to widgets.
 * Widget change events are also monitored to propagate value changes back to the angular scope
 *
 * jqDataTable and jqGrid widgets will automatically set their columns and data based
 * on an underlying table if the columns and source properties are not specified.
 */

function ngJqxsettings($interval, $compile, $parse, dateFilter) {
  function link(scope, element, attrs) {
    var isInitialized = false; // don't actually sync values until initialization is complete

    var widget = attrs.ngJqwidgets; // widget name
    var props = propertyToScope(attrs.ngJqxsettings); // dictionary of widget settings

    // console.log(widget); // for debugging
    // console.log(props);  // for debugging

    // monitor all angular scope variables that are bound to a property
    for (var p in props.scope) {
      var propName = p.concat(''); // copy property name (scoped so we can use it in a closure)
      var scopeVar = props.scope[p]; // the variable we bound it to (scoped so we can use it in a closure)

      // a local variable, to help with binding
      // we replace all periods with __ so the actual scope variable can be in an object hierarchy
      var property = scopeVar.replace('.', '__');
      // console.log(propName);
      eval('var ' + property + ' = scope.' + scopeVar + ';');

      // console.log('var ' + property + ' = scope.' + scopeVar + ';'); // debugging

      // add the current value of the bound variable to the widget's initialization
      props.settings[p] = eval(property);

      // watch for changes in the $scope variables and update the widget accordingly
      scope.$watch(scopeVar, function (newValue, oldValue) {
        if (!isInitialized || (newValue == oldValue)) return; // nothing to update yet

        // we have to loop over all the scope variables to avoid propblems with closure semantices
        for (var p in props.scope) {
          if (props.scope[p] != this.exp) continue;

          // retrieve the actual value, preserving its type
          eval('var exp = scope.' + this.exp);

          // compute the jquery argument to update the parameter
          // and execute the update if that argument is valid
          var updatedProperty = {};
          updatedProperty[p] = exp;
          if (updatedProperty) $(element[0])[widget](updatedProperty);
          break;
        }
      }, true);
    }

    // initializes the widget, and bind changes within the widget back to scope variables when possible
    $(document).ready(function () {
      console.log('Initializing ' + widget);
      console.log(props.settings);
      $(element[0])[widget](props.settings); // initialize the widget

      // watch for changes in the value property if it's bound
      if (props.scope.hasOwnProperty('value')) {
        $(element[0]).on('change', function() {
          var val = $(element[0])[widget]('value');
          eval('scope.' + props.scope.value + ' = val;');
          // console.log('scope.' + props.scope.value + ' = ' + val);
        });
      }

      // initialization is now complete, so start syncing changes
      isInitialized = true;
    });

    // DataTable and Grid widgets:
    // Bind nicely to existing tables by setting columns based on the <thead>
    // and installing a data adaptor for the the <tbody> if columns and source
    // properties are not specified
    if (widget == 'jqxDataTable' || widget == 'jqxGrid') {
      // check for a columns property
      if (!props.settings.hasOwnProperty('columns')) {
        // find all <th> cells and make them columns
        // console.log(element);
        props.settings.columns = [];
        $(element).find('thead th').each(function() {
          var c = {  };

          // allow the <th> to specify a jqxcolumn attribute with jqx column properties
          var attr = $(this).attr('jqxcolumn');
          if (attr) c =  eval(attr);

          // provid reasonable defaults for test, dataField, and displayField
          if (!c.hasOwnProperty('text'))         c.text = $(this).text();
          if (!c.hasOwnProperty('dataField'))    c.dataField = $(this).text();
          if (!c.hasOwnProperty('displayField')) c.dataField = $(this).text();

          // add to the list of columns
          props.settings.columns.push(c);
        });
      }

      // check for a source property
      if (!props.settings.hasOwnProperty('source')) {
        var source = {
          localdata: [],
          datatype: 'array'
        };


        // build a data adaptor based on the existing table data
        // (code based on the implementation in jqxDataTable.js)
        $(element).find('tbody tr').each(function() {
          var row = {};
          for (var i = 0; i < props.settings.columns.length; i++) {
            var td = $(this).find('td:eq(' + i + ')');
            if (td && td.length) row[props.settings.columns[i].text] = td.html();
          }
          source.localdata.push(row);
        });

        props.settings.source = new $.jqx.dataAdapter(source);
        // console.log(props.settings); // for debugging
      }
    }
  };

  return {
    link: link
  };
}

// extracts the key-value pairs from the settings string
// returns a dictionary of dictionaries
//    scope:    mapping of properties to scope variables for anuglar binding
//    settings: mapping of properties to initial values that sholdn't be bound
//
// by defaults, binds the theme property to the theme scope variable
var propertyToScope = function(settingsString) {
  var foundTheme = false; // has the theme property been specified?

  // prepare the dictionaries we will return
  var keyValueObjects = { settings: {}, scope: {} };

  // strip off the surrounding quotes and whitespace?
  console.log(settingsString);
  var newString = settingsString.slice(1, settingsString.length - 1).trim();

  // break the settings into an array of "key: value" strings
  var keyValueArray = newString.split(',');

  // add the settings to the dictionary one by one
  for (var i = 0; i < keyValueArray.length; i++) {
    // split into actual (key, value), skipping empty strings
    var tempArray = keyValueArray[i].trim().split(':');
    if (tempArray[0] == '' || tempArray.length < 2) continue;
    var keyVar   = tempArray[0].trim();
    var scopeVar = tempArray[1].trim();

    if (keyVar == 'theme') foundTheme = true; // we found a theme property

    if (isNaN(scopeVar) == true && scopeVar != 'true' && scopeVar != 'false' && scopeVar[0] != '\'' && scopeVar[0] != '\'') {
      // this looks like a mapping to a scope variable
      // console.log(keyVar + ': ' + scopeVar); // for debugging
      keyValueObjects.scope[keyVar] = scopeVar;
    } else {
      // this looks like an initialization parameter
      keyValueObjects.settings[keyVar] = eval(scopeVar);
    }
  };

  // bind the theme property to the theme variable by default
  if (!foundTheme) keyValueObjects.scope['theme'] = 'theme';

  return keyValueObjects;
};
