# '균형잡힌 괄호 문자열'의 인덱스 변환
def balanced_index(p) :
	count = 0 # 왼쪽 괄호의 갯수
	for i in range(len(p)) :
		if p[i] == '(' :
			count += 1
		else :
			count -= 1
		if count == 0 : # 짝이 맞는 경우 뺐다 더하면 0이 되니까
			return i

# '올바른 괄호 문자열' 인지 판단
def check_proper(p) :
	count = 0 # 왼쪽 괄호의 갯수
	for i in p :
		if i == '(' :
			count += 1
		else :
			if count == 0 : # 쌍이 맞지 않는 경우 (끝까지 가기전에 짝이 맞아버림) False
				return False
			count -= 1
	return True # 쌍이 맞는 경우 True

def solution(p) :
	answer = ''
	if p == '' :
		return answer
	index = balanced_index(p)
	u = p[:index + 1]
	v = p[index+1:]

	# '올바른 괄호 문자열' 이면 v에 대해 함수를 수행한 결과 붙여 반환
	if check_proper(u) :
		answer = u + solution(v)
	# '올바른 괄호 문자열' 이 아니라면 아래의 구정을 수행
	else:
		answer = '('
		answer += solution(v)
		answer += ')'
		u = list(u[1:-1]) #첫번째와 마지막 문자 제거
		for i in range(len(u)) :
			if u[i] == '(' :
				u[i] = ')'
			else :
				u[i] = '('
		answer += "".join(u)
	return answer