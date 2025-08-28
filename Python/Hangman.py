#setup

import time
import random
gussed = False
easy_words = ['useless','attract','charming','touching','chess']
medium_words = ['abruptly','askew','azure','abyss','blizzard','crypt',]
hard_words = ['jazz','buzz','jinx','quiz','fox',]
difficulty_list = ['easy','medium','hard']

#difficulty

while True:
    print("Choose difficulty:")
    time.sleep(0.5)
    print("easy,medium,hard,or random?")
    difficulty=input()
    #random
    if difficulty == 'random' or difficulty == 'Random':
        difficulty = random.choice(difficulty_list)
    #easy    
    if difficulty == 'easy' or difficulty == 'Easy':
        lives = 10
        word = random.choice(easy_words)
        break
    #medium
    elif difficulty == 'medium' or difficulty == 'Medium':
        lives = 10
        word = random.choice(medium_words)
        break
    #hard
    elif difficulty == 'hard' or difficulty == 'Hard':
        lives = 10
        word = random.choice(hard_words)
        break
    #invalid
    else:
        print("Invalid difficulty!")
        time.sleep(0.5)
#more setup       
word_len = len(word)
unknown_word = '_' * word_len
used_letters = []*26
print("The word is",word_len,"letters long")
time.sleep(0.5)

#main game

while lives > 0 and guessed = False:
    print("Lives:",lives)
    time.sleep(0.5)
    print()
    print(unknown_word)
    print()
    time.sleep(0.5)
    print("Please enter one letter!")
    guess = input()
    
    #validate guess 
    
    if len(guess) == 1:
        #if user already gussed the letter
        if guess in used_letters:
            print("You already guessed this letter, try something else!")
            print()
            time.sleep(1)
        #if guess is valid
        else:
            if guess in word:
                used_letters.append(guess)
                unknown_word = guess
            else:
                lives -= 1
                used_letters.append(guess)
            print()
            #print guessed letters
            print("Gussed letters: ",end = '')
            for i in used_letters:
                print(i,end = ' ')
            print()
            time.sleep(0.5)
            
    #if user entered multiple characters
            
    else:
        print("You can only enter one letter!")
        print()
        time.sleep(0.5)
        
if lives <= 0:
    print("You lost!")
    