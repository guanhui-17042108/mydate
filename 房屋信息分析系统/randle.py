import csv
import datetime

import pandas as pd
import numpy as  np


filename=open('D:\lianjia\house1.csv','r',encoding='gbk')
#使用read_csv函数读取数据并生成DateFrame数据表。
dt=pd.read_csv(filename)
print(dt)
dt1=np.array(dt)

#显示列的最多个数，否则将会中间几列用省略号代替
pd.set_option('display.max_columns',21)
#设置宽度，让数据不换行显示
pd.set_option('display.width', 100)
#列名重命名
dt= dt.rename(columns={'id':'id','leixing':'房屋类型','zongjia':'总价','danjia':'单价','huxing':'户型', 'louceng':'楼层','mainji':'建筑面积','jiegou':'结构','taoneimianji':'套内面积'
              ,'jianzhuleixing':'建筑类型','chaoxiang':'朝向','jianzhujiegou':'建筑结构','qingkuang':'情况','dianti':'电梯','tihubili':'电梯比例','gongnuanfangshi':'供暖方式','jiaoyiquanshu':'交易权属','dizhi':'地址','zhuangtai':'交易状态','zhouqi':'周期','shijian':'时间'})
print(dt)
#计算缺失率
print(dt.apply(lambda x:sum(x.isnull())/len(x)))
#时间戳转换为指定格式日期
str1='  2019-01-08'
str2='2019-1-8 00:00:00'
str3='2019年1月8日'
str4='2019年01月08日'
str5='2019/1/8'
str6='2019/01/08 00:00'
str7='2019-1-8'
def str2date(str_date):
    str_date = str_date.strip()
    year = 0000
    month = 0
    day = 0
    if (len(str_date) > 11):
        str_date = str_date[:18]
    if (str_date.find('-') > 0):
        year = str_date[:4]
        #isdigit() 方法检测字符串是否只由数字组成
        if (year.isdigit()):
            year = int(year)
        else:
            year = 0
        #rfind() 返回字符串最后一次出现的位置，如果没有匹配项则返回-1。
        month = str_date[5:str_date.rfind('-')]
        if (month.isdigit()):
            month = int(month)
        else:
            month = 0
        if (str_date.find(' ') == -1):
            day = str_date[str_date.rfind('-') + 1:]
        else:
            day = str_date[str_date.rfind('-') + 1:str_date.find(' ')]
        if (day.isdigit()):
            day = int(day)
        else:
            day = 0
    elif (str_date.find('年') > 0):
        year = str_date[:4]
        if (year.isdigit()):
            year = int(year)
        else:
            year = 0
        month = str_date[5:str_date.rfind('月')]
        if (month.isdigit()):
            month = int(month)
        else:
            month = 0
        day = str_date[str_date.rfind('月') + 1:str_date.rfind('日')]
        if (day.isdigit()):
            day = int(day)
        else:
            day = 0
    elif (str_date.find('/') > 0):
        year = str_date[:4]
        if (year.isdigit()):
            year = int(year)
        else:
            year = 0
        month = str_date[5:str_date.rfind('/')]
        if (month.isdigit()):
            month = int(month)
        else:
            month = 0
        if (str_date.find(' ') == -1):
            day = str_date[str_date.rfind('/') + 1:]
        else:
            day = str_date[str_date.rfind('/') + 1:str_date.find(' ')]
        if (day.isdigit()):
            day = int(day)
        else:
            day = 0
        '''
        hour = str_date[str_date.rfind(' ')+1:str_date.find(':')]
        if (hour.isdigit()):
            hour=int(hour)
        else:
            hour=0
        minutes = str_date[str_date.rfind(':') + 1:-1]
        if (minutes.isdigit()):
            minutes = int(minutes)
        else:
            minutes = 0
        '''
    else:
        year = 0000
        month = 0
        day = 0
    if year <999:
        year='000'+str(year)
    if month < 10:
        month = '0' + str(month)
    if day < 10:
        day = '0' + str(day)
    return '%s-%s-%s' % (year, month, day)
for i in dt['时间']:
  dt2=str2date(str_date=str(i))
  # 如果需要改变原数据，需要添加常用参数 inplace=True
  dt['时间'].replace(i, dt2,inplace=True)
print(dt)
dt['周期'].fillna(0,inplace=True)
print(dt.fillna(0))
print(dt.describe())
#房屋类型缺失值处理,根据房屋类型的众数进行填充
def fangwuleixing():
 sum=0
 sum1=0
 for j in dt['房屋类型']:
    if(j=='二手'):
        sum+=1
    elif(j=='新房'):
        sum1+=1
 if(sum>sum1):
     dt['房屋类型'].fillna('二手',inplace=True)
     print("-----------")
 else:
     dt['房屋类型'].fillna('新房',inplace=True)
fangwuleixing()
print(dt)
print(dt["总价"].fillna(4.066340e+06,inplace=True))
print(dt["单价"].fillna(3.581042e+06,inplace=True))
#计算缺失率
print(dt.apply(lambda x:sum(x.isnull())/len(x)))
"""
#房屋类型缺失值处理,根据房屋类型的众数进行填充
def huxing():
 sum=0
 sum1=0
 sum2=0
 sum3=0
 sum4=0
 for j in dt['户型']:
    if(j=='一室'):
        sum+=1
    elif(j=='二室'):
        sum1+=1
    elif(j=='三室'):
        sum2+=1
    elif(j=='四室'):
        sum3+=1
    elif(j=='四室以上'):
        sum4+=1
    else:
        0
 print(sum)
 print(sum1)
 print(sum2)
 print(sum3)
 print(sum4)
huxing()
"""
dt.fillna(0,inplace=True)
#计算缺失率
print(dt.apply(lambda x:sum(x.isnull())/len(x)))
print(dt.describe())






