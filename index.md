---
layout: default
title: CIS 110 Spring 2021 — Introduction to Computer Programming
active_tab: main-page
attribution: Site adapted from CIS 121 by Michael Hackett, Sierra Mills, and Jules Pierce.
---

{: .dl-horizontal}
Course:
: CIS 110: Spring 2021

Instructors:
: Harry Smith

Teaching Assistants:
: [Course staff]({{site.baseurl}}/staff.html)

Discussion Forum:
: [Piazza](https://piazza.com/upenn/spring2021/cis110)

Live Coding Lectures:
: [Monday (9-10am EST), Wednesday (9-10am EST), Friday (9-10am EST)](https://upenn.zoom.us/j/91762588691)

Office Hours Queue:
: [Office Hours Queue](https://ohq.io/) - search for CIS 110

IDE:
: [Codio](https://codio.com/p/join-course?token=normal-spain) - or use join token normal-spain

Community Slack:
: [CIS 110 21sp Slack](https://join.slack.com/t/cis11021sp/shared_invite/zt-l24fmous-EXaEjOLzbpMxdvCXwiWn8w)

---

CIS 110 Spring 2021: Introduction to Computer Programming

: Introduction to Computer Programming is the first course in our series introducing students to computer science. In this class you will learn the fundamentals of computer programming in Java, with emphasis on applications in science and engineering. You will also learn about the broader field of computer science and algorithmic thinking, the fundamental approach that computer scientists take to solving problems.

---

Announcements

: 
{% for announcement in site.data.announcements %}
    <p>
        {{ announcement.announcement | markdownify }}
    </p>
{% endfor %}
