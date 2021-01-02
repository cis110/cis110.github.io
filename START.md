# CIS 110 Semester Creation README

This document contains instructions on how to create a new semester in the course infrastructure.

## Repo Creation

1. Go to github.com/cis110. If there is a repo named cis110.github.io, rename it to the previous semester's session using a format of "20fa" for example.
2. Create a new repository and name it either cis110.github.io or the current semester's session.
3. Copy this file into the new repository.
4. Recursively copy contents of last sem into current sem
5. Push content as your first commit. You now will have a fresh repo which contains last semester's most recent info as your first commit.

Note: In the future, it would be better to have a starter repo that we can just clone at the beginning of each summer rather than do this, but it works for now.

## Course Account Changes - Website

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

## Course Account Changes - Non-Website

- `ssh` into the course account and note that the `current` directory is a symlink to `content/20su` (where `20su` is the previous semester in this example)
- I do not really know how much of this is important, so do yourself a favor and just copy it all over - `cd content && mkdir 20fa && cp -r 20su 20fa` for example.
- This will take a minute.
- Now `cd ~` and change the symlink for `current` from `content/20su` to `content/20fa` with `rm current && ln -s content/20fa current`
- There is another symlink in the home directory that is the same thing but is named the name of the semester. Because I don't know if that matters, just replace it as well. `rm 20su && ln -s content/20fa 20fa`
- Clean up old files
  - Move the semester's homework folder to `hw_old` and make a new directory called `hw_20fa` (ie)
