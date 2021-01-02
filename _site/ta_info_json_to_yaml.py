import sys

# json format
#	{
	# 	"name": "First Last",
	# 	"email": "pennkey@school",
	# 	"pennkey": "pennkey",
	# 	"role": "TA / mentor",
	# 	"recit": "#",
	# 	"recitTime": "Day Hour-Hour",
	# 	"recitLocation": "BUILDING Room#",
	# 	"oh1": "Day Hour-Hour",
	# 	"oh1Location": "Building",
	# 	"language": "Language",
	# 	"pronouns": "he/him/his"
	# },

# yaml format
# General format - delete any unused fields
# name: First Last
# pic: pic.jpg (png is fine too)
# title: title (Instructor/Head TA/TA/Mentor)
# pronouns: she/her/hers (or whatever they actually are)
# recitation: XXX (Day A-B, Location)
# office_hours: 
  # For TAs: See [calendar](schedule.html)
  # Whatever you want for profs
# email: pennkey@school

key_mapping_json_to_yaml = {"name": "name", "email": "email", "pennkey": "pic", "role": "title", "recitTime": "recitation", "recitLocation": "recitation", "oh1": "office_hours", "oh1Location": "office_hours", "oh2": "office_hours", "oh2Location": "office_hours", "language": "", "pronouns": "pronouns"}

def write_TA_info(tas):
    tas = order_tas(tas)
    with open("output.yaml",'w',encoding='utf-8') as output:
        for ta in tas:
            ta = json_to_yaml_dict(ta)
            output.write("- ")
            for key, value in ta.items():
                if key is not None:
                    if "pic" in key:
                        ta[key] = value + ".jpg"
                    output.write(key + ": " + ta.get(key) + "\n  ")
            output.write("\n")    
        output.close()

def order_tas(tas):
    ordered = list()

    # first, professor then head TAs
    for ta in tas:
        print(ta.get("role"))
        if "Professor" in ta.get("role"):
            print("adding professor")
            ordered.append(ta)
    for ta in tas:
        if "Head TA" in ta.get("role"):
            print("adding head TA")
            ordered.append(ta)
    # diversity and inclusion
    for ta in tas:
        if "TA for Diversity and Inclusion" in ta.get("role"):
            ordered.append(ta)
    
    # then, sort by recitations for TAs and pennkey for mentors after
    for ta in sorted(tas, key = lambda i: i.get("recit") if i.get("recit") is not None else i.get("pennkey")):
        ordered.append(ta)
    
    return ordered

def json_to_yaml_dict(json_format):
    yaml_format = dict()
    recitation = dict()
    for key, value in json_format.items():
        yaml_key = key_mapping_json_to_yaml.get(key)
        if yaml_key is not "":
            if key.startswith("oh"):
                yaml_format[yaml_key] = "See [calendar](schedule.html)"
            elif key.startswith("recit"):
                recitation[key] = value
            else:
                yaml_format[yaml_key] = value
    yaml_format["recitation"] = format_rec(recitation)
    return yaml_format

def format_rec(recitation):
    number = recitation.get("recit")
    date_and_time = recitation.get("recitTime")
    place = recitation.get("recitLocation")
    # recitation: XXX (Day A-B, Location)
    if number is not None and date_and_time is not None and place is not None:
        return str(number) + " (" +  date_and_time.strip() + ", " + place.strip() + ")"
    else: return "No Recitation"
    
def read_file(filename):
    tas = list()
    json_file = open(filename, mode = 'r', encoding = 'utf-8')
    curr_line = json_file.readline()
    curr_TA_info = dict()
    while curr_line is not "":
        if "{" in curr_line:
            curr_TA_info = dict()
        elif "}" in curr_line:
            tas.append(curr_TA_info)
        elif "[" in curr_line or "]" in curr_line:
            pass
        else:
            attrs = clean_line(curr_line).split(":")
            curr_TA_info[attrs[0]] = attrs[1]
        curr_line = json_file.readline()
    write_TA_info(tas)
    json_file.close()
    
def clean_line(line):
    return line.strip().replace("\"","").replace(",","").replace("\t","").replace("\n","")

read_file(sys.argv[1])