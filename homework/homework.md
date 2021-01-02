---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: homework
---
<!-- This file pulls from homework.yaml -->

### Homework

<table class="table table-striped">
  <thead>
    <tr>
      <th>Homework Number</th>
      <th>Name</th>
      <th>Release Date</th>
      <th>Due Date</th>
      <th>FAQ</th>
    </tr>
  </thead>

  <tbody>
    {% for hw in site.data.homework %}
    <tr style="text-align: left">
        <td>{{ hw.homework_number }}</td>
        {% if hw.link %}
        <td><a href = "{{ hw.link }}">{{ hw.name }}</a></td>
        {% else %}
        <td>{{hw.name}}</td>      
        {% endif %}
        <td>{{ hw.release_date }}</td>
        <td>{{ hw.due_date }}</td>
        {% if hw.faq_name %}
        <td><a href = "{{ hw.faq_link }}">{{ hw.faq_name }}</a></td>
        {% else %}
        <td>Coming Soon!</td>
        {% endif %}
    </tr>
    {% endfor %}
  </tbody>
</table>
