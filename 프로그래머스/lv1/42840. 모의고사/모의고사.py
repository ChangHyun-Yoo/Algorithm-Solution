def solution(answers):
    first = [1,2,3,4,5]
    second = [2,1,2,3,2,4,2,5]
    third = [3,3,1,1,2,2,4,4,5,5]
    fir = 0
    sec = 0
    thi = 0
    answer = []
    for i in range(len(answers)):
        if answers[i] == first[i % 5]:
            fir += 1
        if answers[i] == second[i % 8]:
            sec += 1
        if answers[i] == third[i % 10]:
            thi += 1
    max_val = max(fir, sec, thi)
    if max_val == fir:
        answer.append(1)
    if max_val == sec:
        answer.append(2)
    if max_val == thi:
        answer.append(3)
    return answer