def mark(arr,y,x):
    for k in range(8):
        arr[y][k] = 2
    for k in range(8):
        arr[k][x] = 2
    tempY = y; tempX = x
    while tempY >= 0 and tempX >= 0:
        arr[tempY][tempX] = 2
        tempY -= 1; tempX -= 1
    tempY = y; tempX = x
    while tempX < 8 and tempY < 8:
        arr[tempY][tempX] = 2
        tempY += 1; tempX += 1
    

    arr[y][x] = 1
    return arr

B = [0] * 8
for i in range(8):
    s = input()
    B[i] = [0] * 8
    for j in range(8):
        B[i][j] = s[j]

counter = 0
for i in range(8):
    board = B.copy()
    if board[0][i] != '*':
        board = mark(board,0,i)
        for j in range(7):
            for a in range(8):
                for b in range(8):
                    if board[a][b] != 2 and board[a][b] != '*':
                        board = mark(board,a,b)
            
            queens = 0
            for a in range(8):
                for b in range(8):
                    if board[a][b] == 1:
                        queens += 1
            print(board)
            print()
            if queens == 8:
                print(board)
                print()