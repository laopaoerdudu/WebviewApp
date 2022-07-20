#### 让你的H5实现秒开

参考：

https://mp.weixin.qq.com/s/yEKj21WHa9hIdQ-dljG2ow

https://github.com/miaowmiaow/fragmject

#### 浏览器为什么能唤起App的Activity？

html 标签有一个属性 `href`，比如：`<a href="...">`。

我们常见的一种用法：`<a href="``https://www.baidu.com``">`。也就是点击之后跳转到百度。

当然这里和 android 交互的流程基本一致：用隐式调用的方式，声明需要启动的 `Activity`；然后 `<a href="">传入对应的协议（scheme`）即可。比如：

前端页面：

```
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<a href="mdove://wwe"> 启动 WWEActivity </a>
</body>
```

android声明：

```
<activity
    android:name=".WWEActivity"
    android:screenOrientation="portrait">
    <intent-filter>
        <data
            android:host="wwe"
            android:scheme="mdove" />
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.BROWSABLE" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
</activity>
```

Ref:

https://mp.weixin.qq.com/s/ml09w1KfQ9MbVQZX036qUg