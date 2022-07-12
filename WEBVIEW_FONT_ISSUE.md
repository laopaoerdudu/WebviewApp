#### Android webView 的字体突然变小了?

下面是一段自己拼接的 html：

```
<span style="word-wrap:break-word;font-family:system-ui;font-size:16px;color:#888888;">Https://www.baidu.com</span>
```

`setLoadWithOverviewMode` 这个方法的作用，就是是否根据屏幕宽度自适应。

总结：

1，如果 html 是自己拼接的，并且像素是 px，不要设置 `WebViewSetting` 的 `setLoadWithOverviewMode` ，
`setUseWideViewPort`（默认属性是 false），否则字体可能显示不正常，偏大或者偏小。

2，如果 html 是自己拼接的，并且像素是 px，当我们设置 `WebViewSetting` 的 `setLoadWithOverviewMode`，
`setUseWideViewPort` 为 true（根据屏幕自适应），那么我们需要设置 html 的 viewport 规则，否则可能显示不正常。

```
parsedHtml += "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover\">";
```

#### WebView 字体常见的其他坑

1、默认浏览器中的内容是不受系统字体大小设置控制的，至少我遇到的几台手机都是这样的情况。

2、某些机型 WebView 字体的大小是受手机系统字体大小控制的。

问题解决方案来自这篇文章：
https://blog.csdn.net/FungLeo/article/details/73309396




