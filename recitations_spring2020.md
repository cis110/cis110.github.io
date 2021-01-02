---
layout: default
title: CIS 110 Syllabus
active_tab: recitations
---

### CIS 110 Recitation Schedule

Here is the CIS 110 Recitation schedule. This information has been updated as of **May 23**. If you are in a large recitation and would like to move to a smaller recitation, please feel free to do so! We would love to have all of the recitations be around the same size. **Each recitation is capped at 20 students.**

Remember that CIS 110 offers two types of recitations: One hour recitations and two hour recitations. The two hour recitations are designed for students with no prior coding experience and get to delve further into reviewing the material and contain more coding examples.


<table class="table table-striped">
    <thead>
        <tr>
            <th>Recitation Number</th>
            <th>TA One</th>
            <th>TA Two</th>
            <th>Meeting Date and Time</th>
            <th>Location</th>
            <th>Number of Students</th>
        </tr>
    </thead>
    <tbody>
        {% for recitation in site.data.recitations %}
        <tr>
            <td>
            {{ recitation.rec_number }}
            </td>
            {% if recitation.ta_one %}
            <td>
            {{ recitation.ta_one }}
            </td>
            {% else %}
            <td>
            Coming Soon!
            </td>
            {% endif %}
            <td>
            {{ recitation.ta_two }}
            </td>
            <td>
            {{ recitation.day_and_time }}
            </td>
            <td>
            {{ recitation.location }}
            </td>
            <td>
            {{ recitation.student_count }}
            </td>
        </tr>
        {% endfor %}
    </tbody>
</table>
