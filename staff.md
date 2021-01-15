---
layout: default
title: CIS 110 Staff
active_tab: staff
---

<div class="container-fluid">
  <div class="row">
  {% for staff in site.data.staff %}
      <div class="col-lg-4 col-md-6 col-xs-12" style="margin-bottom: 20px; height: 350px;">
        <ul class="list-unstyled">
          <li>
          {% if staff.pic %}
            <img src="assets/img/staff/{{ staff.pennkey }}.jpg" alt="" class="img-circle" style="height: 100%; width: 100%; max-height: 250px; max-width: 250px">
          {% else %}
            <img src="assets/img/staff/java.jpg" alt="" class="img-circle" style="height: 100%; width: 100%; max-height: 250px; max-width: 250px">
          {% endif %}
          </li>
          <li>
            {% if staff.li %}
            <b><a href="{{ staff.li }}">{{ staff.name }}</a></b> <em>{{staff.pronouns}}</em>
            {% else %}
            <b>{{ staff.name }}</b> <em>{{staff.pronouns}}</em>
            {% endif %}
          </li>
          <li>
            <em>{{ staff.title }}</em>
          </li>
          {% if staff.languages %}
            <li>
              <b>Additional Languages:</b> {{ staff.languages }}
            </li>
          {% endif %}
          <!-- {% if staff.recitation %}
            <li>
              <b> Recitation:</b> 
              <a href="recitations.html">{{ staff.recitation }}</a>
            </li>
          {% endif %} -->
          {% if staff.office_hours %}
            <li>
              <b>Office Hours:</b> {{ staff.office_hours | inline_markdownify }}
            </li>
          {% endif %}
          {% if staff.email %}
            <li>
                <b>Email:</b> <a href="mailto:{{staff.email}}"><code>{{ staff.email }}</code></a>
            </li>
          {% endif %}
        </ul>
      </div>
    {% endfor %}
  </div>
</div>
