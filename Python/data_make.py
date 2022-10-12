import random
import numpy as np
import csv


#打印6次课程
for course_num in range(1,6):
    with open('../kotlin/data/course'+str(course_num)+'.csv', 'w') as m:
            student_num = []
            st = []
            arr = []
            #创建csv文件表头
            word = '学号' + ',' + '性别' + ',' + '年龄' + ',' + '绩点' + ',' + '出勤1' + ',' + '出勤2' + ',' + '出勤3' + ',' + '出勤4' + ',' + '出勤5' + ',' + '出勤6' + ',' + '出勤7' + ',' + '出勤8' + ',' + '出勤9' + ',' + '出勤10' + ',' + '出勤11' + ',' + '出勤12' + ',' + '出勤13' + ',' + '出勤14' + ',' + '出勤15' + ',' + '出勤16' + ',' + '出勤17' + ',' + '出勤18' + ',' + '出勤19' + ',' + '出勤20'
            m.write('{}\n'.format(word))
            #初始化点名情况二维数组
            value = [[1 for j in range(24)] for i in range(90)]
            ran = random.sample(range(32002100, 32002999), 90)
            for i in range(90):
                ran[i] = str(ran[i])
                value[i][0] =ran[i].zfill(9)
                # print(value[i][0])
            # 生成性别
            for i in range(90):
                sex = random.randint(0, 1)
                if sex == 1:
                    value[i][1] = '男'
                else:
                    value[i][1] = '女'
            # 生成年龄
            for i in range(90):
                age = random.randint(20, 23)
                value[i][2] = age
            # 生成大概率缺课同学的个数
            large_num = random.randint(5, 8)
            # 统计个数
            count = 0
            # 生成绩点,并确保绩点的值正确
            grade = np.random.normal(2.7, 0.7, 90)
            for i in range(90):
                while grade[i] > 4 or grade[i] < 0:
                    grade[i] = np.random.normal(2.7, 0.7, 1)
            grade.sort()
            for i in range(90):
                value[i][3] = grade[i]
            # 生成最可能没来的5-8个学生
            course = []
            student = []
            for i in range(20):
                course.append(i)
            for i in range(90):
                student.append(i)
            for i in range(90):
                temp = random.choice(range(100))
                if temp < 70 and count < large_num:
                    count+=1
                    slice = random.sample(course, 16)
                    for j in slice:
                        value[i][j+4] = 0
            # 生成每节课小概率没来的0-3个学生
            for i in range(20):
                small_num = random.randint(0, 3)
                slice = random.sample(student, small_num)
                for j in slice:
                    value[j][i+4] = 0
            for j in range(90):
                information = format(value[j][0]) + ',' + str(value[j][1]) + ',' + str(value[j][2]) + ',' + str(value[j][3]) + ',' + str(value[j][4]) + ',' + str(value[j][5]) + ',' + str(value[j][6]) + ',' + str(
                    value[j][7]) + ',' + str(value[j][8]) + ',' + str(value[j][9]) + ',' + str(value[j][10]) + ',' + str(
                    value[j][11]) + ',' + str(value[j][12]) + ',' + str(value[j][13]) + ',' + str(value[j][14]) + ',' + str(
                    value[j][15]) + ',' + str(value[j][16]) + ',' + str(value[j][17]) + ',' + str(value[j][18]) + ',' + str(
                    value[j][19]) + ',' + str(value[j][20]) + ',' + str(value[j][21]) + ',' + str(value[j][22]) + ',' + str(
                    value[j][23])
                m.write("{}\n".format(information))
