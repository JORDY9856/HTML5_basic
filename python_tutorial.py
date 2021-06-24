#반복문

def chat(name1, name2, age): #def 함수를 사용하겠다고 선언
  print("%s:형"%name1)
  print("%s:왜불렁 나는 %d" (%name2, %age)

chat("알렉스", "크리스", 10)
chat("동생", "형", 20)
chat("바이스", "닭다리",30)


# 함수를 만들 때 return 꼭 쓰기

def dsum(a,b):
  result= a+b
  return=result (줄맞춤 주의)

d=(1,2)
print(d)

#중간 정리
#먼저 이름과 나이를 받아라
#나이가 10살 미만이면 "안녕" 라고 말하라
#나이가 10살 ~20살 사이면 "안녕하세요"라고 말하라
#그외에는 "안녕하십니까"라고 말하라

def sayHello(name, age):
  if age < 10:
    print("안녕,," + name)
  elif age <=20 and age>=10:
    print("안녕하세요," +name)
  else:
    print("안녕하십니까,"+name)

sayHello("윤하", 20)
sayHello("정석", 35)
sayHello("가즈아", 50)



#반복문 (for, while)

for i in range(10):
  print(i)
  print("철수: 안녕 영희")
  print("영희: 안철수!")


i=0
while i< 3:
  print(i)
  print("철수: 안녕 영희")
  print("영희: 안철수!")
  i= i+1


#break , continue

i=0
while True:
  print(i)
  print("철수: 안녕 영희")
  print("영희: 안철수!")
  i= i+1

  if i>2:
    break

i=0
for i in range(100):
  print(i)
  print("철수: 안녕 영희")
  print("영희: 안철수!")
  
  if i>2:
    break


i=0
for i in range(3):
  print(i)
  print("철수: 안녕 영희")
  print("영희: 안철수!")
  
  if i== 1:
    continue # i가 1일 때에만 실행
  print("워니: 안녕 간철수")


#리스트 듀플 딕셔너리

x= [4,1,2,3]

num = len(x)
print(num)

y= sorted(x)
print(y)

z= sum(x)
print(z)



x= [4,1,2,3]
y=["hello", "there"]
for n in x:
  print(n)

for c in y:
  print(c)

print(x.index(3)) # 3이 어디에 있어?
print(y.index("there"))
print("hello" in y) #y에 hello가 있나? 있으면 true



#tuple() #소괄호 사용. (불변: 값을 바꿀수 없다)



#dic{} 
#딕셔너리는 {} 사용. key와 value로 이러어짐. 
#key에는 불변의 값만 올 수 있다(list불가)

x= {
  0:"워니",
  1:"age",
  "you":20,
}

print("age" in x)
print(x.keys)
print(x.values)

for key in x:
  print("key:"+ str(key))	#key를 보여줌
  print("value:"+ str(x[key]))	#value를 보여줌

x["school"]="한빛" #dic에 key값이 school이고 밸류가 한빛 인 값 추가
print(x)


#정리
fruit = ["사과","사과","사과","바나나","바나나","딸기","키위","키위","키위","키위"]

d = {} #dic 만들기

for f in fruit: #f = "사과" 라는 key가 한번씩 들어감

  if f in d:    #"사과"라는 key가 d라는 dic에  들어있어?
    d[f] = d[f] + 1 # 그럼 "사과"의 갯수+1  
  else:
    d[f] = 1 #없다면 dic에 넣고 밸류를 1로 만들어줘

print(d)