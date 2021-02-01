---
layout: default
title: CIS 110 Internal
active_tab: writeups
---
<!-- This file pulls from writeups.yaml -->

### Writeups

---

{% for writeup in site.data.writeups %}

#### [{{ writeup.title }}](writeups/{{ writeup.folder }}/{{ writeup.link }})
Description: {{ writeup.info }}

_Published {{ writeup.published | date: '%a, %b %-d, %Y' }}_

{% if writeup.last_edited %}
_Last Updated: {{ writeup.last_edited | date: '%a, %b %-d, %Y' }}_
{% endif %}

---

{% endfor %}

