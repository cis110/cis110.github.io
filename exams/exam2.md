---
layout: default
title: CIS 110 Exams
active_tab: exam2
---

### Exam 2

#### Details

- **Date** December 4
- **Duration** 2 hours
- **Time** 12am EST - 11:59pm EST
- **Location** Canvas

---

#### Makeup Requests

You must have a valid conflict with another exam to request a makeup.

- Post a private question to Piazza in the **exam1-makeup-request** folder no later than **TBD @ 11:59 pm**. Include the reason for your request in your post, and your availability (including time ranges) on **June TBD, TBD, and TBD**. Give the reasons for every conflict.
- We will respond to your post at some point after TBD to tell you if you have permission to take the makeup exam, and with the time and location.
- After TBD @ 11:59 pm we will only authorize makeups in exceptional circumstances, with supporting documentation.

---

#### Topics Covered

- **What will be on the exam?** Anything we have covered in lecture, homeworks, the reading assignments, and/or recitation is fair game for the exam. It is reasonable to assume that topics we have dealt with more extensively are likely to feature more prominently than topics we have only touched on, although anything is possible.

- **Will X be on the exam?** Please refer to the previous section. To ensure all students receive identical information about what will and will not be on the exam, course staff have been instructed to refer students to this page without commenting further.

---

#### Current and Previous Exams

- Please remember that the selection and order of topics varies somewhat from semester to semester, so previous exams may include questions that are not relevant to this semester, and they may not cover all topics that may be examined this semester.

<table class="table table-striped">
  <thead>
    <tr>
      <th>Term</th>
      <th>Questions</th>
      <th>Answers</th>
      <th>Median</th>
      <th>Total Points</th>
      <th>Standard Deviation</th>
      <th>Corrections</th>
    </tr>
  </thead>
  
  <tbody>
    {% for exam in site.data.exam2 %}
      <tr style="text-align: left">
        <td>{{ exam.term }}</td>
        <td>
          {% if exam.questions %}
            <a target="_blank" href="{{ site.baseurl }}/assets/exams/exam2/{{ exam.questions }}">Questions</a>
          {% else %}
            Coming soon!
          {% endif %}
        </td>
        <td>
          {% if exam.answers %}
            <a target="_blank" href="{{ site.baseurl }}/assets/exams/exam2/{{ exam.answers }}">Answers</a>
          {% else %}
            Coming soon!
          {% endif %}
        </td>
        <td>
          {% if exam.median %}
            {{ exam.median }}
          {% else %}
            Coming soon!
          {% endif %}
        </td>
        <td>
          {% if exam.total_points %}
            {{ exam.total_points }}
          {% else %}
            Coming soon!
          {% endif %}
        </td>
        <td>
          {% if exam.standard_deviation %}
            {{ exam.standard_deviation }}
          {% else %}
            Coming soon!
          {% endif %}
        </td>
        <td>
          {% if exam.corrections %}
          <ul class="list-unstlyed">
            {% for correction in exam.corrections %}
              <li> {{ correction }} </li>
            {% endfor %}
          </ul>
          {% endif %}
        </td>
      </tr>
    {% endfor %}
  </tbody>
</table>
