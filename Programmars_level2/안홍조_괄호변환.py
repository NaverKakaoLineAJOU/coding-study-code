def solution(p):

    answer = progress(p)
    return answer

def progress(p):
    if p=="":
        return ""
    u,v=div(p)
    if right(u):
        return u+progress(v)
    else:
        reverseU=""
        for i in range(1,len(u)-1):
            if u[i]=="(":
                reverseU +=")"
            else:
                reverseU += "("
        return "("+progress(v)+")"+reverseU


def div(p):
    num=0
    length=len(p)
    for i in range(length):
        if p[i]=="(":
            num+=1
        elif p[i]==")":
            num-=1
        if num==0:
            break
    return p[0:i+1], p[i+1:length]

def right(p):
    stack=[]
    try:
        for i in p:
            if i == "(":
                stack.append("(")
            elif i == ")":
                stack.pop()
    except:
        return False

    if len(stack)==0:
        return True
    return False
