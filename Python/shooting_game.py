import random
import sys

def print_board(arr):
    for i in range(len(arr)):
        for j in range(len(arr)):
            print(arr[i][j],end = '')
        print()

def check_valid_move():
    if move == 'end':
        print('score - ',score)
        sys.exit()
        
    if move == 'up':
        if loc_y > 0:
            if board[loc_y-1][loc_x] == '*' or board[loc_y - 1][loc_x] == '#':
                return True
            else:
                return False
        else:
            return False
                
    if move == 'down':
        if loc_y < 9:
            if board[loc_y+1][loc_x] == '*' or board[loc_y + 1][loc_x] == '#':
                return True
            else:
                return False
        else:
            return False
        
    if move == 'right':
        if loc_x < 9:
            if board[loc_y][loc_x+1] == '*' or board[loc_y][loc_x+1] == '#':
                return True
            else:
                return False
        else:
            return False
        
    if move == 'left':
        if loc_x > 0:
            if board[loc_y][loc_x-1] == '*' or board[loc_y][loc_x-1] == '#':
                return True
            else:
                return False
        else:
            return False
    
    if move == 'fire_right':
        print(random.choice(gun_sounds))
        return True
    if move == 'fire_left':
        print(random.choice(gun_sounds))
        return True
    if move == 'fire_up':
        print(random.choice(gun_sounds))
        return True
    if move == 'fire_down':
        print(random.choice(gun_sounds))
        return True
    
    if move == 'clean_right':
        return True
    if move == 'clean_left':
        return True
    if move == 'clean_up':
        return True
    if move == 'clean_down':
        return True
    
    
    return False

def action():
    valid_move = False
    global loc_y
    global loc_x
    global move
    global moves
    global score
    while not valid_move:
        move = input()
        if check_valid_move():
            board[loc_y][loc_x] = '-'
            #move---------------------------------
            if move == 'up':
                loc_y -= 1
                if board[loc_y][loc_x] == '#':
                    moves -= 2
                board[loc_y][loc_x] = '^'
                
            if move == 'down':
                loc_y += 1
                if board[loc_y][loc_x] == '#':
                    moves -= 2
                board[loc_y][loc_x] = '^'
                
            if move == 'right':
                loc_x += 1
                if board[loc_y][loc_x] == '#':
                    moves -= 2
                board[loc_y][loc_x] = '>'
                
            if move == 'left':
                loc_x -= 1
                if board[loc_y][loc_x] == '#':
                    moves -= 2
                board[loc_y][loc_x] = '<'
            
            #fire----------------------------------
            if move == 'fire_right':
                board[loc_y][loc_x] = '>'
                
                for x in range(loc_x + 1,10):
                    if board[loc_y][x] == 'x':
                        score += 1
                    board[loc_y][x] = '-'
            
            if move == 'fire_left':
                board[loc_y][loc_x] = '<'
                
                for x in range(0,loc_x):
                    if board[loc_y][x] == 'X':
                        score += 1
                    board[loc_y][x] = '-'
                
            if move == 'fire_up':
                board[loc_y][loc_x] = '^'
                
                for y in range(0,loc_y):
                    if board[y][loc_x] == 'x':
                        score += 1
                    board[y][loc_x] = '-'

            if move == 'fire_down':
                board[loc_y][loc_x] = '^'
                
                for y in range(loc_y + 1,10):
                    if board[y][loc_x] == 'x':
                        score += 1
                    board[y][loc_x] = '-'
            
            #clean---------------------------------------
            if move == 'clean_right':
                board[loc_y][loc_x] = '>'
                
                for x in range(loc_x + 1,10):
                    board[loc_y][x] = '*'
            
            if move == 'clean_left':
                board[loc_y][loc_x] = '<'
                
                for x in range(0,loc_x):

                    board[loc_y][x] = '*'
                
            if move == 'clean_up':
                board[loc_y][loc_x] = '^'
                for y in range(0,loc_y):
                    board[y][loc_x] = '*'

            if move == 'clean_down':
                board[loc_y][loc_x] = '^'
                for y in range(loc_y + 1,10):
                    board[y][loc_x] = '*'
            
            valid_move = True
            
        else:
            
            print('invalid move!')
    
#make board-----------------------------------------------
board = ['*'] * 10

for i in range(10):
    board[i] = ['*'] * 10

random_x = random.choice([1,2,3,4,5,6,7,8,9])
random_y = random.choice([1,2,3,4,5,6,7,8,9])

board[random_y][random_x] = '>'
loc_x = random_x; loc_y = random_y

gun_sounds = ['bang!','kabloom!','kablooie!','pew!']

counter = 0
while counter < 5:
    random_x = random.choice([1,2,3,4,5,6,7,8,9])
    random_y = random.choice([1,2,3,4,5,6,7,8,9])
    
    if board[random_y][random_x] == '*':
        counter += 1
        board[random_y][random_x] = '#'

enemies = 0
while enemies < 10:
    random_x = random.choice([1,2,3,4,5,6,7,8,9])
    random_y = random.choice([1,2,3,4,5,6,7,8,9])
    
    if board[random_y][random_x] == '*':
        enemies += 1
        board[random_y][random_x] = 'x'
     
#play game------------------------------------------------------
moves = 0; score = 0
while score != enemies and moves < 15:
    print_board(board)
    print('moves left-',15 - moves)
    moves += 1
    action()
    

print_board(board)
print('You killed',score,'enemies in',moves,'moves!')