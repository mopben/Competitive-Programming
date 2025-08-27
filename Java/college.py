print("Are You Eligible For College?")

start = str(input("Start???? Yes or No or IDK?: "))

def do_not_start():
    print("Why not???")
    print("I know you want to do it!!!!")
    print("It's useful for you!")
def idk():
    print("Anyways... Thanks. Have a good day!")

while (True):
    if start == "No":
        do_not_start()
        break
    elif start == "IDK":
        idk()
        break
    elif start == "Yes":
        continue

