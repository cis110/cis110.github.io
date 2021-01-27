---
layout: default
title: CIS 110 Sunday Review Sessions
active_tab: sundady_review_sessions
---

### Sunday Review Sessions

Each week, we will post the worksheet and answers for the sunday review sesion held. Here are the weekly SRS times and zoom links:
- 10am - 12pm ET: [Zoom link](https://upenn.zoom.us/j/98657403898?pwd=dU5iWnN6Z2lveFcveEMwQUZWM2h6dz09)
- 2pm - 4pm ET: [Zoom link](https://upenn.zoom.us/j/96303051832?pwd=bnE0cUNremxCVStrUXpsMnpFaUtRQT09)
- 5pm - 7pm ET: [Zoom link](https://upenn.zoom.us/j/95393869543?pwd=RzZzL0M0WVlKWFlYbTZialEwMmxSZz09)

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
