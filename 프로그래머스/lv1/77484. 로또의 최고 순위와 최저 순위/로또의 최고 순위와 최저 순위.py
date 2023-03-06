def solution(lottos, win_nums):
    c = 0
    cz = 0
    for i in lottos:
        for j in win_nums:
            if i == j:
                c = c + 1
        if i == 0:
            cz = cz + 1
    max = 0
    min = 0
    dic = {0:6,1:6, 2:5, 3:4, 4:3, 5:2, 6:1}
    max = dic[c+cz]
    min = dic[c]
    answer = [max, min]
    return answer