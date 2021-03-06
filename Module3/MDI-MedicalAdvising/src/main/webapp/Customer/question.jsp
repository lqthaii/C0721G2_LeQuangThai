<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/11/2021
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="../assets/font/fontawesome/css/all.css">
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/main.css">
    <link rel="stylesheet" href="../assets/css/question.css">
    <link rel="icon" href="../assets/image/881599_medical_512x512.png" type="image/x-icon">
    <title>Medical Advice</title>
</head>
<!--Start of Tawk.to Script-->
<script type="text/javascript">
    var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
    (function () {
        var s1 = document.createElement("script"), s0 = document.getElementsByTagName("script")[0];
        s1.async = true;
        s1.src = 'https://embed.tawk.to/612f4f1bd6e7610a49b31057/1fegcq1ck';
        s1.charset = 'UTF-8';
        s1.setAttribute('crossorigin', '*');
        s0.parentNode.insertBefore(s1, s0);
    })();
</script>
<!--End of Tawk.to Script-->

<body>
<div class="app">
    <jsp:include page="../header.jsp"/>
    <!-- Container Begin -->
    <div class="container">
        <div class="grid">
            <div class="grid__row">
                <div class="grid__column-9">
                    <div class="question">
                        <div class="question__form">
                            <form action="/question" method="post" enctype="multipart/form-data">
                                <div class="question__form__container">
                                    <h3>?????t c??u h???i mi???n ph??</h3>
                                    <div class="question__content">
                                    <textarea rows="5" id="question__content__textarea" name="questionContent"
                                              placeholder="L??u ?? m?? t??? chi ti???t n???i dung mu???n h???i b??c s??:
                                    - Gi???i t??nh, tu???i;
                                    - Tri???u ch???ng g???p ph???i;
                                    - B???t ?????u c?? tri???u ch???ng khi n??o;
                                    - ???? d??ng bi???n ph??p x??? l?? n??o ch??a?" spellcheck="true"></textarea>
                                        <div class="question__form__img-review">
                                            <!-- js here -->
                                        </div>
                                        <div class="question__form__upload">
                                            <label for="upload-photo">aaa</label>
                                            <i class="fas fa-paperclip"></i>
                                            <span for="upload-photo">Th??m file ????nh k??m(t???i ??a 4 ???nh)</span>
                                            <input type="file" id="upload-photo" name="photo" accept="image/*" multiple>
                                            <button class="btn_question_submit" type="submit">G???i</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="question__container">
                        <div class="question__view">
                            <div class="question__answer__container">
                                <a href="#">
                                    <img src="https://upload.api.edoctor.io/image/614aba56d6e2474f11138a1e" alt=""
                                         class="question__answer__img">
                                    <h2 class="question__answer__heading">X??? l?? th??? n??o khi c???m th???y t??c ng???c huy???t ??p
                                        t??ng
                                        160/130</h2>
                                    <div class="answer__container">
                                        <img src="../assets/image/maxresdefault.jpg"
                                             alt="" class="doctor__img">
                                        <div class="answer__info">
                                            <div class="answer__hint">???????c tr??? l???i b???i</div>
                                            <div class="doctor__name">Nguy???n Anh Qu???c</div>
                                            <div class="doctor__exp">50 n??m kinh nghi???m</div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                            <div class="question__answer__container">
                                <a href="#">
                                    <img src="https://upload.api.edoctor.io/image/614aba56d6e2474f11138a1e" alt=""
                                         class="question__answer__img">
                                    <h2 class="question__answer__heading">X??? l?? th??? n??o khi c???m th???y t??c ng???c huy???t ??p
                                        t??ng
                                        160/130</h2>
                                    <div class="answer__container">
                                        <img src="../assets/image/maxresdefault.jpg"
                                             alt="" class="doctor__img">
                                        <div class="answer__info">
                                            <div class="answer__hint">???????c tr??? l???i b???i</div>
                                            <div class="doctor__name">Nguy???n Anh Qu???c</div>
                                            <div class="doctor__exp">50 n??m kinh nghi???m</div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                            <div class="question__answer__container">
                                <a href="#">
                                    <img src="https://upload.api.edoctor.io/image/60f1651838f6fe9a9e6f2897" alt=""
                                         class="question__answer__img">
                                    <h2 class="question__answer__heading">X??? l?? th??? n??o khi c???m th???y t??c ng???c huy???t ??p
                                        t??ng
                                        160/130</h2>
                                    <div class="answer__container">
                                        <img src="../assets/image/maxresdefault.jpg"
                                             alt="" class="doctor__img">
                                        <div class="answer__info">
                                            <div class="answer__hint">???????c tr??? l???i b???i</div>
                                            <div class="doctor__name">Nguy???n Anh Qu???c</div>
                                            <div class="doctor__exp">50 n??m kinh nghi???m</div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                            <div class="question__answer__container">
                                <a href="#">
                                    <img src="https://upload.api.edoctor.io/image/60f675c3bbe16f00125d0b5f" alt=""
                                         class="question__answer__img">
                                    <h2 class="question__answer__heading">X??? l?? th??? n??o khi c???m th???y t??c ng???c huy???t ??p
                                        t??ng
                                        160/130</h2>
                                    <div class="answer__container">
                                        <img src="../assets/image/maxresdefault.jpg"
                                             alt="" class="doctor__img">
                                        <div class="answer__info">
                                            <div class="answer__hint">???????c tr??? l???i b???i</div>
                                            <div class="doctor__name">Nguy???n Anh Qu???c</div>
                                            <div class="doctor__exp">50 n??m kinh nghi???m</div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                            <div class="question__answer__container">
                                <a href="#">
                                    <img src="https://upload.api.edoctor.io/image/60f7f475bbe16f00125d0b84" alt=""
                                         class="question__answer__img">
                                    <h2 class="question__answer__heading">X??? l?? th??? n??o khi c???m th???y t??c ng???c huy???t ??p
                                        t??ng
                                        160/130</h2>
                                    <div class="answer__container">
                                        <img src="../assets/image/maxresdefault.jpg"
                                             alt="" class="doctor__img">
                                        <div class="answer__info">
                                            <div class="answer__hint">???????c tr??? l???i b???i</div>
                                            <div class="doctor__name">Nguy???n Anh Qu???c</div>
                                            <div class="doctor__exp">50 n??m kinh nghi???m</div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                            <div class="question__answer__container">
                                <a href="#">
                                    <img src="https://upload.api.edoctor.io/image/614aba56d6e2474f11138a1e" alt=""
                                         class="question__answer__img">
                                    <h2 class="question__answer__heading">X??? l?? th??? n??o khi c???m th???y t??c ng???c huy???t ??p
                                        t??ng
                                        160/130</h2>
                                    <div class="answer__container">
                                        <img src="../assets/image/maxresdefault.jpg"
                                             alt="" class="doctor__img">
                                        <div class="answer__info">
                                            <div class="answer__hint">???????c tr??? l???i b???i</div>
                                            <div class="doctor__name">Nguy???n Anh Qu???c</div>
                                            <div class="doctor__exp">50 n??m kinh nghi???m</div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="question__filter grid__column-3">
                    <div class="question__filter__wrapper">
                        <input type="text" class="question__input" placeholder="T??m ki???m c??u h???i">
                        <button class="question-search__btn">T??m ki???m</button>
                    </div>
                    <div class="question-popular__wrapper">
                        <h2 class="question-popular__heading">T??m ki???m ph??? bi???n</h2>
                        <div class="question-popular__container">
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng b???ng</span>
                            <span class="question-popular__content">??au b???ng</span>
                            <span class="question-popular__content">??au b???ng b???ng</span>
                            <span class="question-popular__content">??au b???ng b???ng b???ng</span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- Container End -->
    <!-- Container End -->

    <!-- Footer Begin -->
    <div class="footer-main">
        <footer>
            <div class="social"><a href="#"><i class="fab fa-facebook"></i></a><a href="#"><i
                    class="fab fa-facebook-messenger"></i></a><a href="#"><i class="fab fa-twitter"></i></a><a
                    href="#"><i class="fab fa-instagram"></i></a></div>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Trang ch???</a></li>
                <li class="list-inline-item"><a href="#">Services</a></li>
                <li class="list-inline-item"><a href="#">About</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
            </ul>
            <p class="copyright">Company Name ?? 2021</p>
        </footer>
    </div>
    <!-- Footer End -->
</div>
</body>
<script src="../js/main.js"></script>
<script src="../js/question.js"></script>
</html>
