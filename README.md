# course-website-20fa

Website for Penn's Intro to Computer Programming course (CIS 110 Fall 2020).
Adapted from CIS 121.


## Installation

1. Install [Ruby](https://www.ruby-lang.org/en/) and the [Bundler
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

**Note**: Due to eniac running old versions of a lot of software, you may have difficulty
setting up the environment locally. You can also try using your own seas page
(`www.seas.upenn.edu/~yourpennkey`) as a staging environment or as last resort
just building on the cis110 account.

## Updating Content

Jekyll is a static site builder that allows users to modify (for the most part) only yaml and md files and then builds html files for you in a \_site folder. Never touch the \_site folder, as it is rebuilt and changes will be discarded. To edit yaml files, go to \_data - this includes announcements, exams, homework, navigation bar, recitations, staff, SRS, and the syllabus. The md files themself iterate over the contents of these yaml files and format the page accordingly, so you only need to change those md files if you want to change how the page will look.

For individual homework, we change the md, not the yaml. The homework.yaml file is an enumeration of the assignments, whereas the homework folder actually contains the files which will be built into the homework html files.

### Syllabus

Update \_data/syllabus.yaml following the instructions at the top.

### Schedule

You can embed a Google Calendar into the site. The 20sp google calendar is still embedded, so just follow that format.

### Staff

The repo will have an existing staff csv file. Create a new one following the same format. Then, if it is semester "20fa", run "python3 ta_info_csv_to_yaml.py 20fa_staff.csv". Then go to \_data/staff_temp.yaml, verify it looks alright, and move it into \_data/staff.yaml. Make sure that assets/img/staff has image files for each individaul following the naming convention of <pennkey>.jpg. Rebuild and load the staff page and verify it is as expected.

Note that the script does not contain information regarding pronouns or additional languages spoken from the TAs because the staff csv file (probably) does not have that. As of now we update that manually.

As of July 22, this has been completed already.


### Pushing announcements or exams

Update the yaml pages only

### Pushing Homework

First, edit the relevant markdown file in the homework folder. They are updated for the 20sp semester, including base files.
After doing this, the only file that needs to change to make a homework live is homework.yaml. This will dynamically update the navigation bar and the homework.html table so that students can access it. Just uncomment the link and rebuild.

For TAs to complete the homework, the link already exists, the markdown file just needs to be updated. The link will be of the form "cis.upenn.edu/~cis110/current/homework/<homework_name>.html". For example, hw00 is https://www.cis.upenn.edu/~cis110/current/homework/hello_world.html even though the link isn't published to students.

## Structural Changes

### Nested Structure

Files which can be found within a dropdown share a common prefix with the other files in that same dropdown. For example, all policy files can be found at {{ site.baseurl }}/policies/filename.html. This is enforced via 1) a "prefix" attribute in the navigation.html file as well as 2) a directory with that same prefix name within the repository

### Updating the header

Update the navigation.yaml page. DO NOT touch navigation.html or default.html - those pull from the yaml.

### Updating the base URL

Change the baseurl in \_config.yaml. You will need to restart your local server for changes to take effect.

## Pushing to Prod

Because CETS would need to put jekyll into our course account and I don't feel like figuring that out, we are keeping \_site in the repository so that we don't need to build from the course account. Here's the commands to run.

Just ssh into the course account and run ./push_site_to_prod.sh
