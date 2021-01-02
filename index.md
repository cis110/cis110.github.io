---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: main-page
attribution: Site adapted from CIS 121 by Michael Hackett, Sierra Mills, and Jules Pierce.
---

{: .dl-horizontal}
Course:
: CIS 110: Fall 2020

Instructors:
: Eric Fouh and Harry Smith

Teaching Assistants:
: [Course staff]({{site.baseurl}}/staff.html)

Discussion Forum:
: [Piazza](https://piazza.com/upenn/fall2020/cis1102020c)

Live Coding Lectures:
: Monday (12-1pm EDT), Wednesday (11am-12pm EDT), Friday (12-1pm EDT)

Office Hours Queue:
: [Office Hours Queue](https://ohq.io/) - search on CIS 110

---

CIS 110 Fall 2020: Introduction to Computer Programming

: Introduction to Computer Programming is the first course in our series introducing students to computer science. In this class you will learn the fundamentals of computer programming in Java, with emphasis on applications in science and engineering. You will also learn about the broader field of computer science and algorithmic thinking, the fundamental approach that computer scientists take to solving problems.

---

Announcements

: 
{% for announcement in site.data.announcements %}
    <p>
        {{ announcement.announcement | markdownify }}
    </p>
{% endfor %}
