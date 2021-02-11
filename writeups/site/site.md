---
layout: default
title: CIS 110 Internal
active_tab: site
---

# CIS 110 Website

## Brief Intro

All websites can be broadly divided into two sets: **static** sites and **dynamic** sites. A static site will deliver the same content to every user whereas a dynamic site is in some way personalized. Twitter, for example, is a **dynamic** site - you have a custom feed curated for your account, and in the backend, there is a database that is holding the info that was just loaded onto your screen. Something like cis110.com is a static site - if you go to the homepage, it will look the same to you as it does to everyone else. As you navigate through a static site, you're just traversing a tree of html files that are loaded into your browser as you go. Because cis110.com is a static site, this guide will be focused on the following skills and tools:

- Our modern solution for our website, including development and deployment
- Day to day edits for the site including
  - Releasing homework
  - Modifying the syllabus
  - Adding staff info
- Setting up a new semester

Once comfortable with the information in this guide, you should be able to edit the website yourself, as well as be prepared to launch the next semester's site. We're going to skip over what it used to be like to develop websites in the past and just jump right into modern approaches to keep this guide to a bearable length, but we may put together an introduction to web development that will go over writing HTML, and take the time to discuss dynamic site creation as well.

_Note: some information in this guide is pulled from the README.md and START.md files that you can find in the 21sp repository for our infra committee._

## Jekyll: A Static Site Generator

Jekyll is the software we use to develop our website. Jekyll is a static site generator, and is [one of many](https://jamstack.org/generators/) that exist. Working with a Jekyll site involves working with yaml files for data and markdown files for general content. Jekyll then compiles your markdown and yaml files into html which you can view in your browser.

---

## Our Site

The following section goes over the installation and editing of the website.

## Installation

1. Install [Ruby](https://www.ruby-lang.org/en/) version 2.6 and the [Bundler
   gem](https://bundler.io). If you are using a Mac, you already have Ruby
   installed, so the following command should work (maybe needing `sudo`):

   ```
   $ gem install bundler
   ```

2. Install this project's dependencies from Bundler.

   ```
   $ bundle install
   ```

3. Build and run the website locally. (Note that all Jekyll commands such as
   `jekyll build` or `jekyll serve` must be prefixed with `bundle exec`.)

   ```
   $ bundle exec jekyll serve --watch --incremental
   ```

4. Sometimes, the local development becomes annoying and refuses to build
   files automatically. In that case, open a new terminal tab and run
   `jekyll build` every time you make a change. This tends to happen when editing yaml files.

   Now, navigate to [`http://localhost:4000/`](http://localhost:4000), and
   you should see the website!


## Updating Content

Jekyll is a static site builder that allows users to modify (for the most part) only yaml and md files and then builds html files for you in a \_site folder. Never touch the \_site folder, as it is rebuilt and changes will be discarded. To edit yaml files, go to \_data - this includes announcements, exams, homework, navigation bar, recitations, staff, SRS, and the syllabus. The md files themself iterate over the contents of these yaml files and format the page accordingly, so you only need to change those md files if you want to change how the page will look.

For individual homework, we change the md, not the yaml. The homework.yaml file is an enumeration of the assignments, whereas the homework folder actually contains the files which will be built into the homework html files.

### Syllabus

Update \_data/syllabus.yaml following the instructions at the top. As of Spring 2021, we have a script for converting from csv -> yaml in the util repository.

### Schedule

You can embed a Google Calendar into the site. The 20sp google calendar is still embedded, so just follow that format.

### Staff

The repo will have an existing staff csv file. Create a new one following the same format. Then, if it is semester "20fa", run "python3 ta_info_csv_to_yaml.py 20fa_staff.csv". Then go to \_data/staff_temp.yaml, verify it looks alright, and move it into \_data/staff.yaml. Make sure that assets/img/staff has image files for each individaul following the naming convention of <pennkey>.jpg. Rebuild and load the staff page and verify it is as expected.

Note that the script does not contain information regarding pronouns or additional languages spoken from the TAs because the staff csv file (probably) does not have that. As of now we update that manually.

### Pushing announcements or exams

Update the yaml pages only! The markdown files don't need to change. You can upload new exam pdfs into the assets/exams/examX directory.

### Pushing Homework

First, edit the relevant markdown file in the homework folder. They are updated for the 21sp semester, including base files.
After doing this, the only file that needs to change to make a homework live is homework.yaml. This will dynamically update the navigation bar and the homework.html table so that students can access it. Just uncomment the link and rebuild.

For TAs to complete the homework, the link already exists, the markdown file just needs to be updated. The link will be of the form "cis.upenn.edu/~cis110/current/homework/<homework_name>.html". For example, hw00 is https://www.cis.upenn.edu/~cis110/current/homework/hello_world.html even though the link isn't published to students.

## Structural Changes

### Nested Structure

Files which can be found within a dropdown share a common prefix with the other files in that same dropdown. For example, all policy files can be found at {{ site.baseurl }}/policies/filename.html. This is enforced via 1) a "prefix" attribute in the navigation.html file as well as 2) a directory with that same prefix name within the repository

### Updating the header

Update the navigation.yaml page. DO NOT touch navigation.html or default.html - those pull from the yaml.

### Updating the base URL

Change the baseurl in \_config.yaml. You will need to restart your local server for changes to take effect.

### Pushing to Prod

Push your changes to the git repository, and then ssh into the course account and run the script `push_site_to_prod.sh`.

---

## Setting up a New Semester

Once a semester, we need to reconstruct the site. A semi-hidden secret is that you can visit any past semester's cis110 website by changing the word 'current' in the url to the semester. For example, Fall 2020's site can be accessed at <https://www.cis.upenn.edu/~cis110/20fa/>, and similarly, Spring 2019 can be visited at <https://www.cis.upenn.edu/~cis110/19sp/>.

Because we keep up every semester's site, that means we can't just edit the existing site repository to prep for a new semester. Instead, we need to make a new git repository, copy the contents of last semester's site into it, and then go about resetting the markdown and yaml files for the new semester. We always name the repositories the name of the semester, so next semester's repo will be called '21fa'.

The following are detailed instructions on how to accomplish this for both repository setup and the corresponding course account changes necessary for a new semester.

### Repo Creation

1. Go to github.com/cis110. If there is a repo named cis110.github.io, rename it to the previous semester's session using a format of "20fa" for example.
2. Create a new repository and name it either cis110.github.io or the current semester's session.
3. Copy this file into the new repository.
4. Recursively copy contents of last sem into current sem
5. Push content as your first commit. You now will have a fresh repo which contains last semester's most recent info as your first commit.

Note: In the future, it would be better to have a starter repo that we can just clone at the beginning of each summer rather than do this, but it works for now.

### Course Account Changes - Website

- ssh into the course account (ssh cis110@eniac.seas.upenn.edu). Navigate into ~/html and perform mkdir 20fa (replace 20fa with current semester).
- Now change the symlink for current, which is now pointing to last semester, to the folder you just created
  - Use `ls -l current` to confirm the symlink exists.
  - Do `rm current` to remove symlink
  - Do `ln -s 20fa current` to attach symlink of current -> correct semester
  - Now, `~/html/current` will be an empty folder
- Next, we need to update our course account's repo folder. Do `cd ~/repo` and `mkdir 20fa` (again, replace with correct semester). Now perform the same symlink work as in html - `ls -l current` to confirm it exists, `rm current` to remove it, and `ln -s 20fa current` to attach to new semester. `cd` into that directory and then:
  - `git init`
  - `git remote add origin https://github.com/cis110/20fa.git`
  - `git pull origin master`
  - `git branch --set-upstream-to=origin/master`
- If you now try to visit cis110.com, you will notice that it does not work (hard refresh if it loads content from your cache) - specifically you will receive a 403, as the `~/html/current` directory does not have read access granted yet.
- One time procedure: Do `chmod a+rx ~/html/current` to provide read access on the contents of the `current` folder
- Run `./push_site_to_prod` and load the site now, you should see your website rendered.
  - Note: the script uses the `current` symlinks to pull from git and push to the html folders, so MAKE SURE they are correct before running the script or you risk writing over existing information.

At this point, you are set to begin editing the site on your local device. Make sure to build the `_site` folder before pushing to git. Then, just ssh into the course account and run the push script and you will see your changes.

### Course Account Changes - Non-Website

- `ssh` into the course account and note that the `current` directory is a symlink to `content/20su` (where `20su` is the previous semester in this example)
- I do not really know how much of this is important, so do yourself a favor and just copy it all over - `cd content && mkdir 20fa && cp -r 20su 20fa` for example.
- This will take a minute.
- Now `cd ~` and change the symlink for `current` from `content/20su` to `content/20fa` with `rm current && ln -s content/20fa current`
- There is another symlink in the home directory that is the same thing but is named the name of the semester. Because I don't know if that matters, just replace it as well. `rm 20su && ln -s content/20fa 20fa`
- Clean up old files
  - Move the semester's homework folder to `hw_old` and make a new directory called `hw_20fa` (ie)
