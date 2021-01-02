---
layout: default
title: CIS 110 Syllabus
active_tab: syllabus
---

### CIS 110 Syllabus

- This is a tentative syllabus and schedule.  Topics, reading assignments, and due dates are subject to change.  This syllabus will be updated throughout the semester, so please reload this page before lectures to get the up to date version.
- Lecture recordings are available to registered students on the [course canvas page](https://canvas.upenn.edu/courses/1507941). Recordings are added within an hour of lecture's end.

---

<table class="table table-striped">
    <thead>
        <tr>
            <th>Date</th>
            <th>Topics</th>
            <th>Example Code</th>
            <th>HW Assigned</th>
            <th>HW Due</th>
            <th>Lecture Recording</th>
            <th>Module Videos</th>
            <th>Recitation Materials</th>
            <th>Announcements</th>
        </tr>
    </thead>
    <tbody>
        {% for lecture in site.data.syllabus %}
        {% if lecture.hw_due %}
        <tr class="success">
        {% else if lecture.flag %}
        <tr class="{{ lecture.flag }}">
        {% else %}
        <tr>
        {% endif %}
            <td>{{ lecture.date | date: '%a, %b %-d, %Y' }}</td>
            <td> 
                {% if lecture.topics %}
                    {% if lecture.slides %}
                        <a target="_blank" href="lectures/{{ lecture.slides }}">{{ lecture.topics }}</a>
                    {% else %}
                        {{ lecture.topics }}
                    {% endif %}
                {% endif %}
            </td>
            <td>
                {% if lecture.examples[0] %}
                {% for example in lecture.examples %}
                    {% if example.example_code_url %}
                        <a target="_blank" href="lectures/examples/{{ example.example_code_url }}">{{ example.example_code }}</a>
                    {% else %}
                        {{ example.example_code }}
                    {% endif %}
                {% endfor %}
                {% endif %}
            </td>
            <td>
                {% if lecture.hw_assigned %}
                    {{ lecture.hw_assigned}}
                {% endif %}
            </td>
            <td>
                {% if lecture.hw_due %}
                    {{ lecture.hw_due }} @ 11:59pm!
                {% endif %}
            </td>
            <td>
                {% if lecture.lecture_recording %}
                    {% if lecture.lecture_url %}
                        <a target="_blank" href="{{ lecture.lecture_url }}">{{ lecture.lecture_recording }}</a>
                    {% else %}
                        {{ lecture.recitation_slides }}
                    {% endif %}
                {% endif %}
            </td>
            <td>
                {% if lecture.modules[0] %}
                {% for module in lecture.modules %}
                    {% if module.link %}
                    <a target="_blank" href="{{ module.link }}"> {{ module.name }}</a>
                    {% endif %}
                {% endfor %}
                {% endif %}
            </td>
            <td>
                {% if lecture.recitation_slides %}
                    {% if lecture.recitation_url %}
                        <a target="_blank" href="{{ lecture.recitation_url }}">{{ lecture.recitation_slides }}</a>
                    {% else %}
                        {{ lecture.recitation_slides }}
                    {% endif %}
                {% endif %}
            </td>
            <td>
                {% if lecture.announcement %}
                    {{ lecture.announcement }}
                {% endif %}
            </td>
        </tr>
        {% endfor %}
    </tbody>
</table>