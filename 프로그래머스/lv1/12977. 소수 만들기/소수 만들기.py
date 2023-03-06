def solution(nums):
    result = 0
    answer = 0
    for i in range(len(nums)):
        result = 0
        for j in range(i + 1, len(nums)):
            for k in range(j + 1, len(nums)):
                result = nums[i] + nums[j] + nums[k]
                
                for f in range(3, int(result/2) + 1):
                    if result % f == 0:
                        break
                    elif result % f != 0 and f == int(result/2):
                        answer = answer + 1

    return answer