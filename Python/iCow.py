#setup ----------------------------------------
n,t = input().split()
n = int(n)
t = int(t)
songs = [] * n
maxRating = 0 

for i in range(n):
    songs.append(int(input()))
    
#main loop -----------------------

for j in range(t):
    testN = n
    for a in range(n):
        if songs[a] > maxRating:
            maxRating = songs[a]
            maxSong = a+1
    print(maxSong)
#calculate distribution and reset maxRating and max Song
    if maxRating // n - 1 < 1:
        songDistribution = 0
    else:
        songDistribution = maxRating // (n - 1)
    #print("songDistribution-",songDistribution)
    songRem = maxRating - (songDistribution * (n - 1))
    songRem = int(songRem)
    songs[maxSong - 1] = 0
    
#distribute the maxSong---------------------------------------      

    for b in range(n):
        if b != maxSong - 1:
            songs[b] += songDistribution
    for c in range(songRem):
        if c != maxSong - 1:
            if c < n:
                songs[c] += 1
            else: 
                c = 0
        else:
            
            d = c

            
            for d in range(c,songRem + 1):
                if d != maxSong - 1:

                    if d < n:
                        songs[d] += 1
                    else:
                        d = 0
            break
    maxSong = 0
    maxRating = 0
    songRem = 0

