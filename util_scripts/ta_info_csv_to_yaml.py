import sys

# csv format:
# Full Name,pennkey,email@school,Position,PennID,?
# Example: Michael Hackett,hackett1,hackett1@sas.upenn.edu,Head TA,85867776,1

# yaml format
# General format - delete any unused fields
# name: First Last
# pic: pic.jpg (png is fine too)
# title: title (Instructor/Head TA/TA/Mentor)
# pronouns: she/her/hers (or whatever they actually are)
# recitation: XXX (Day A-B, Location)
# office_hours: 
  # For TAs: See [calendar](schedule.html)
  # Whatever you want for profs
# email: pennkey@school

output_file = "_data/staff_temp.yaml"

def write_TA_info(tas):
    tas = order_tas(tas)
    with open(output_file,'w',encoding='utf-8') as output:
        for ta in tas:
            output.write("- ")
            for key, value in ta.items():
                if key is not None:
                    if "pic" in key and ".jpg" not in value:
                        ta[key] = value + ".jpg"
                    output.write(key + ": " + ta.get(key) + "\n  ")
            output.write("\n")    
        output.close()

def order_tas(tas):
    ordered = list()

    # first, professor then head TAs
    for ta in tas:
        if "Professor" in ta.get("title"):
            print("adding professor")
            ordered.append(ta)
            tas.remove(ta)
    for ta in tas:
        if "Head TA" in ta.get("title"):
            print("adding head TA")
            ordered.append(ta)
    # diversity and inclusion
    for ta in tas:
        if "TA for Diversity and Inclusion" in ta.get("title"):
            ordered.append(ta)
    
    # infra
    for ta in tas:
        if "Infrastructure" in ta.get("title"):
            ordered.append(ta)
    
    # then, sort by recitations for TAs and pennkey for mentors after
    for ta in sorted(tas, key = lambda i: i.get("recitation") if i.get("recitation") is not None else i.get("pennkey")):
        ordered.append(ta)
    
    return ordered
    
def read_file(filename):
    tas = list()
    csv_file = open(filename, mode = 'r', encoding = 'utf-8')
    curr_line = csv_file.readline()
    while (curr_line is not ""):
        curr_TA_info = dict()
        tokens = curr_line.split(",")
        tokens = [clean(token) for token in tokens]
        print(tokens)
        if len(tokens) == 7:
            # assumes order does not change
            curr_TA_info["name"] = tokens[0]
            curr_TA_info["pennkey"] = tokens[1]
            curr_TA_info["pic"] = tokens[1]
            curr_TA_info["email"] = tokens[2]
            curr_TA_info["title"] = tokens[3]
            if "OH TA" not in curr_TA_info["title"]:
                curr_TA_info["recitation"] = "Coming Soon!"
            curr_TA_info["office_hours"] = "See [calendar](schedule.html)"

            # if this is the header row, ignore
            if curr_TA_info["pennkey"] != "PennKey":
              tas.append(curr_TA_info)
        curr_line = csv_file.readline()
    write_TA_info(tas)
        

def clean(token):
    return token.replace("\n", "")


read_file(sys.argv[1])