# attendanceCheckingAlgorithm

福州大学软件工程第二次结对编程作业

关于此次项目的具体说明，详见这篇博客：[第二次结对编程](https://bbs.csdn.net/topics/608574230)

## 环境搭建

由于未能解决编译打包可执行文件后的文件 IO 问题，因此此次项目需要使用 **PyCharm** 与 **IDEA** 对 python 文件以及 Kotlin 文件进行编译（如果有其他的 IDE 或编译手段可以自行下载源代码进行编译）

IDEA 下载链接：https://www.jetbrains.com.cn/idea/

PyCharm 下载链接：https://www.jetbrains.com.cn/pycharm/

（下载专业版需要获得授权，可以 30 天试用，高校学生可以使用教育邮箱获得授权）

在运行项目之前，请确保系统内有 Python 以及 Java 的运行环境

Python 下载链接：https://www.python.org/downloads/

Java 下载链接：https://www.oracle.com/java/technologies/downloads/

请自行选择适合系统的版本下载，安装过程省略

## 运行代码

首先，使用```git clone```命令克隆该项目

关于 git 的详细教程，详见：https://www.liaoxuefeng.com/wiki/896043488029600

或者点击绿色 “code” 按钮下载项目压缩包到本地

### 数据集生成

打开 PyCharm，选择打开项目（open），项目地址为 **attendanceCheckingAlgorithm/Python**

进入设置页面（Preference），选择 **Project:Python-Python Interpreter**，点击“+”搜索 **numpy** 后点击 **install package** 完成导入

![完成导入界面](https://tva1.sinaimg.cn/large/008vxvgGly1h73hfon9sij314u0u0wgk.jpg)

点击 **data_make.py**，点击右上角绿色运行按钮即可运行代码

![](https://tva1.sinaimg.cn/large/008vxvgGly1h73hhexlgzj31bb0u0tak.jpg)

![运行结果界面](https://tva1.sinaimg.cn/large/008vxvgGly1h73hhqo4znj31bb0u0gnz.jpg)

生成文件保存在 **attendanceCheckingAlgorithm/Kotlin/data** 中

生成文件格式为 csv 文件，带有标题行，分别记录学号、性别、年龄以及每次课程的到位情况

### 点名算法

打开 IDEA，选择打开项目（open），项目路径为 **attendanceCheckingAlgorithm/Kotlin**

点击右上角的编译项目按钮（Build Project），对项目进行编译

在左侧选择 **main.kt**，右键选择 **Run 'MainKT'**，或在右上角选择点击运行按钮，运行main.kt

![点击顺序](https://tva1.sinaimg.cn/large/008vxvgGly1h73hpd9mt2j31bb0u0te0.jpg)

运行后将会在命令行输出以下结果：

![](https://tva1.sinaimg.cn/large/008vxvgGly1h73hq7fzqdj327a0i03yv.jpg)

可以选择数据来源文件夹（仅限在 Kotlin 目录下，并且保证文件夹内存放有数据），输入 0 使用默认来源（data）

![](https://tva1.sinaimg.cn/large/008vxvgGly1h73hru07qgj327o0hszkw.jpg)

选择结果存放文件夹（需保证提前建立此文件夹），输入 0 输出到默认文件夹（result）

![](https://tva1.sinaimg.cn/large/008vxvgGly1h73ht33jhtj32800ioq5o.jpg)

得到 E 的值，并且结果存放在 **attendanceCheckingAlgorithm/Kotlin/result** 中，以 csv 文件形式存储，记录每一天点名的学生学号以及其到位情况（1 为到位，0 为未到）

![结果默认存放地点](https://tva1.sinaimg.cn/large/008vxvgGly1h73huwtqhij31aa0j0q4j.jpg)

![查看生成的cvs文件（使用VsCode查看）](https://tva1.sinaimg.cn/large/008vxvgGly1h73hvla00qj31gx0u0dnr.jpg)

至此，项目运行完毕。