---
layout: default
title: CIS 110 Internal
active_tab: gradescope
---

# CIS 110 Gradescope Guide
In general, Gradescope has fantastic customer support, so if you run into problems, I highly recommend you try looking at their documentation or shoot them an email! I usually get a response within 24 hours, and they've even helped debug autograders before.

## Linking with Canvas
Gradescope has a fantastic feature that allows you to integrate it with a Canvas course, but for some reason Penn doesn't officially endorse it as an option so it isn't enabled by default on Gradescope courses at Penn. To get it enabled, email help@gradescope.com and they'll set it up pretty quickly for you. Once they've set it up, there should be a "Link to Canvas" button that you can click and then search for the Canvas course.

### Roster
The main feature we use here is to maintain the roster. Once you've set up the linked Canvas course, on the Roster page of Gradescope you can click "Sync Canvas Roster" which will import all people enrolled on Canvas and send them an enrollment notification. You'll have to do this very regularly through the add period, and then after that it's not as important. 

There's also a button on the Roster page called Send Enrollment Notification. This will only send the email to people who have not yet logged in to the course, so you don't need to worry about spamming people with it. This is useful when a student inevitably tells you they were never enrolled in the course.

On the roster page, there will be a column titled Canvas and it will have a little link symbol. To see which accounts are no longer linked, you can click on the word Canvas and it will brink the non-linked accounts to the top. These are typically students that dropped the course, and you'll want to click the red X to remove them from the Gradescope as well.

If students change their Canvas email in between times that you sync the course, they'll end up with two accounts on Gradescope which will likely wreak havoc on our infrastructure. If one of their two accounts has no submissions, it's safe for you to remove the account with no submissions. If they have submissions in both accounts, you can ask them to follow the instructions [here](https://help.gradescope.com/article/ipjyg27lg5-student-merge-accounts) to merge their accounts, or you can email help@gradescope.com and ask them to do it for you.

You can download the Gradescope roster from the Roster page as well. This can be useful for some of our course infrastructure and scripts.

### Assignments
In the settings of an assignment, there is an option to link that assignment to an assignment in Canvas. We've never used this feature, so I'm not sure what it does, but I suspect it allows you to sync their assignment grades to Canvas and have them show up in Canvas. Keep in mind that if you do this, you'll have to configure the Canvas so that it displays their overall course grade correctly, or you'll end up with some unhappy students.

---

## Quizzes
Quizzes for the most part are pretty self-explanatory. Create a new assignment by clicking New Assignment from the Assignments page, select quiz, and then fill out the settings fields before creating the assignment.You can use the "insert field" button if you're not sure of the format for a specific question-type, or you can just type out the plaintext if you know what it requires. Gradescope will preview your quiz on the right as you go, so you can see what it looks like.

The assignment settings can be a little confusing, so here is what we use for the weekly check-in quizzes. You also have to go to the Review Grades and click "Publish" so that students can see their grades as soon as they submit.
- **Questions and student work visibility**: show always
- **Rubric item visibility**: show all rubric items
- **Answer visibility**: show explanations when students answer a question correctly
- **Short answer questions**: strip leading and trailing whitespace *and* case insensitive match.

--- 

## Homework Assignments
To create a homework assignment, you'll click Create Assignment on the Assignments page and then select Programming Assignment. Fill out the necessary fields, and make sure you remember to enable late submissions and manual grading. Once you click create, it'll take you to the page to upload your autograder. Instructions for creating the autograder will be included in a separate wiki.

If you run into issues with the autograder timing out, the Assignment Settings page has settings for CPU, Ram, and timeout of the autograder, and you can mess around with those settings. 

To set up the rubric for a homework assignment, you'll need to click on a submission under Manage Submissions and navigate through the questions the same way you would if you were grading. If this isn't a new assignment, you can import the rubric from a previous semester. If it is a new assignment or you're changing the rubric, then you'll just add the rubric items manually. 

When you're ready to publish grades, you can press "Publish Grades" on the Review Grades page. This will allow students to see their grade, but won't notify them. There should be a notify students button that appears after you publish grades, which will allow you to edit the email that goes out. We typically keep all the stats that they have except for the minimum grade. This is also a good place to remind them of the regrade request policy.

---

## Regrade Requests
By default, Gradescope enables regrade requests with no end date. To get to regrade request settings, if you're on the Assignments or Dashboard page, click on the assignments label in the regrade requests column (will either be On, Off, or a number). If you're in the assignment, you can click Regrade Requests on the left. Once you're on the regrades page, the button for settings is in the bottom right. You can either disable them or set an end date, depending on what functionality you want.

---

## Exams
For all types of exams we've given, we use gradescope for grading. If the exam was in person, you'll scan all the exams into PDF form and then upload the scans to gradescope. If the exam was on Canvas, you'll convert those to PDF form (I'll make a separate writeup for this if we decide it might happen again), and upload that PDF to Gradescope.

On the Gradescope side, the Assignment type you want is Exam, and the instructors will be the ones uploading the exams. You'll need to upload a template (a scan of a blank exam, for in person), and then highlight all the areas where students would have written work. If this is being manually graded, it doesn't need to be super accurate, but if you're planning to use the Gradescope autograding feature, this should be fairly accurate.

Once you've uploaded all the exams, Gradescope should be able to manually separate them and assign them to students. If it can't separate them, it likely means you're missing a page somewhere or have an extra page somewhere, which will cause problems in the future. However, you can manually separate them on the same page you uploaded the scans. There will likely be a few students who don't get manually assigned (and this is where you'll have issues if they have two accounts). You can click on the unassigned students and search for their name manually.

For manually graded questions, setting up the rubric is mostly the same process as it is for homework assignments. You'll want to click Grade Individually when prompted.

If you'd like to autograde fill in the blank or multiple choice, select Grade in Groups and the type of question you have. Gradescope will form the groups, and then show you each one so you can visually confirm the group is correct. It will then show you the ungrouped questions, which you can either move into an existing group, create a new group for, or leave ungrouped. Once you're done grouping, you'll grade like normal, but you'll only see one answer from each group, and the same grade will be assigned to the entire group.

> Note: When creating the groups, I recommend you only group answers that are actually the same, and don't make a generic "incorrect" group. If you have to retroactively give credit to an answer you graded as incorrect, this will make your life a lot easier. 