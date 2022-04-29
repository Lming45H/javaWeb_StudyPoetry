<%@page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <script src="./static/js/jquery-3.5.1.min.js"></script>
    <script src="./static/js/index.js"></script>
    <link rel="stylesheet" href="./static/css/index.css">
</head>
<body>

<div class="wrap">
    <div class="back">
        <div class="back__slide active">
            <div class="progress"></div>
        </div>
        <div class="back__slide">
            <div class="progress"></div>
            <div class="back-front-image"></div>
        </div>
    </div>
    <div class="card">
        <div class="card__slide active">
            <div class="image"></div><span class="number">01</span><span class="date">28 April 2022 <span class="date__time">12:37PM</span></span>
        </div>
        <div class="card__slide">
            <div class="back-image"></div>
            <div class="image"></div><span class="number">02</span><span class="date">28 April 2022 <span class="date__time">12:37PM</span></span>
        </div>
        <div class="content">
            <div class="content__slide active">
                <h2 class="title"> <span class="title__line"> <span class="title__inner">八十二万首诗</span></span><span class="title__line"> <span class="title__inner">等你来挑战</span></span></h2>
                <p class="desc">四朝十帝尽风流，建业长安两醉游。惟有一篇杨柳曲，江南江北为君愁。<br/> 柳烟花雨记春初，梦断江南半载馀。直到东篱黄菊放，故人才寄数行书。<br/> 本数据库收录历代中国诗歌.</p>
                <div class="button-wrap"><a class="button"  href="./jsp/login.jsp" target="_blank">Learn More<span class="button__hover"></span></a></div>
            </div>
            <div class="content__slide">
                <h2 class="title"> <span class="title__line"> <span class="title__inner">中国历代诗歌</span></span><span class="title__line"> <span class="title__inner">Heights</span></span></h2>
                <p class="desc">人去也，人去画楼中。不是尾涎人散漫，何须红粉玉玲珑，端有夜来风。<br/> 人何在？人在玉阶行。不是情痴还欲住，未曾怜处却多心，应是怕情深。<br/>旌心白水是前因，觑浴何曾许别人？煎得兰汤三百斛，与君携手祓征尘。</p>
                <div class="button-wrap"><a class="button" href="./jsp/login.jsp" target="_blank">Learn More<span class="button__hover"></span></a></div>
            </div>
            <div class="content__ping content__ping--noanimation"></div>
        </div>
    </div>
</div>
</body>
</html>
