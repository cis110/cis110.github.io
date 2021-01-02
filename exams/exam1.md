---
layout: default
title: CIS 110 Exams
active_tab: exam1
---

### Exam 1

#### Details

- **Date** October 23 9am - October 24 9am EDT
- **Duration** 130 minutes
- **Location** Canvas

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
    {% for exam in site.data.exam1 %}
      <tr style="text-align: left">
        <td>{{ exam.term }}</td>
        <td>
          {% if exam.questions %}
            <a target="_blank" href="{{ site.baseurl }}/assets/exams/exam1/{{ exam.questions }}">Questions</a>
          {% else %}
            Coming soon!
          {% endif %}
        </td>
        <td>
          {% if exam.answers %}
            <a target="_blank" href="{{ site.baseurl }}/assets/exams/exam1/{{ exam.answers }}">Answers</a>
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
