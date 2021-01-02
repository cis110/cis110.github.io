---
layout: default
title: CIS 110 Sunday Review Sessions
active_tab: sundady_review_sessions
---

### Sunday Review Sessions

Each week, we will post the worksheet and answers for the sunday review sesion held. See Piazza for SRS scheduling.

---

<table class="table table-striped">
    <thead>
        <tr>
            <th>Date</th>
            <th>Worksheet</th>
            <th>Answers</th>
        </tr>
    </thead>
    <tbody>
        {% for srs in site.data.sunday_review_sessions %}
        <tr>
            <td>
                {{srs.date}}
            </td>
            <td>
            {% if srs.worksheet %}
                <a href="{{ srs.worksheet }}">{{ srs.topics }}</a>
            {% else %}
                {{ srs.topics }}
            {% endif %}
            </td>
            <td>
            {% if srs.answers %}
                <a href="{{ srs.answers }}" >Answer Key</a>
            {% endif %}
            </td>
        </tr>
        {% endfor %}
    </tbody>
</table>
