<script lang="ts">
export default {
  name: "AboutView"
}
</script>
<template>
  <div class="about">
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Login Page</title>
      <!--      <link rel="stylesheet" href="styles.css">-->
      <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    </head>
    <body>
    <div class="about">
      <div class="svg-top">
        <!--        <?xml version="1.0" encoding="utf-8"?>-->
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" height="1337" width="1337">
          <defs>
            <path id="path-1" opacity="1" fill-rule="evenodd" d="M1337,668.5 C1337,1037.455193874239 1037.455193874239,1337 668.5,1337 C523.6725684305388,1337 337,1236 370.50000000000006,1094 C434.03835568300906,824.6732385973953 6.906089672974592e-14,892.6277623047779 0,668.5000000000001 C0,299.5448061257611 299.5448061257609,1.1368683772161603e-13 668.4999999999999,0 C1037.455193874239,0 1337,299.544806125761 1337,668.5Z" />
            <linearGradient id="linearGradient-2" x1="0.79" y1="0.62" x2="0.21" y2="0.86">
              <stop offset="0" stop-color="rgb(88,62,213)" stop-opacity="1" />
              <stop offset="1" stop-color="rgb(23,215,250)" stop-opacity="1" />
            </linearGradient>
          </defs>
          <g opacity="1">
            <use xlink:href="#path-1" fill="url(#linearGradient-2)" fill-opacity="1" />
          </g>
        </svg>
      </div>
      <div class="svg-bottom">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" height="896" width="967.8852157128662">
          <defs>
            <path id="path-2" opacity="1" fill-rule="evenodd" d="M896,448 C1142.6325445712241,465.5747656464056 695.2579309733121,896 448,896 C200.74206902668806,896 5.684341886080802e-14,695.2579309733121 0,448.0000000000001 C0,200.74206902668806 200.74206902668791,5.684341886080802e-14 447.99999999999994,0 C695.2579309733121,0 475,418 896,448Z" />
            <linearGradient id="linearGradient-3" x1="0.5" y1="0" x2="0.5" y2="1">
              <stop offset="0" stop-color="rgb(40,175,240)" stop-opacity="1" />
              <stop offset="1" stop-color="rgb(18,15,196)" stop-opacity="1" />
            </linearGradient>
          </defs>
          <g opacity="1">
            <use xlink:href="#path-2" fill="url(#linearGradient-3)" fill-opacity="1" />
          </g>
        </svg>
      </div>

      <section class="container1">
        <section class="wrapper">
          <header>
            <div class="logo">
              <img src="../assets/logo.png" alt="网站Logo" >
            </div>
            <h1 >Welcome back!</h1>
            <div class="logWord">
              <span >用户登录</span>
            </div>
          </header>
          <section class="main-content">
            <form action="">
              <input type="username" placeholder="姓 名">
              <div class="line"></div>
              <input type="password" placeholder="密 码">
              <button >登录</button>
            </form>
          </section>
          <footer>
            <p><a href="" title="Forgot Password">Forgot Password?</a></p>
            <p><a href="" title="Register">Register</a></p>
          </footer>
        </section>
      </section>
    </div>
    </body>
    </html>
  </div>
</template>

<style>
@import url("https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap");
body {
  margin: 0;
  height: 100vh;
  overflow: hidden;
  background-color: #DBE0F9;
  font-family: "Roboto", sans-serif;
}
body .svg-top {
  position: absolute;
  top: -900px;
  right: -300px;
}
body .svg-bottom {
  position: absolute;
  bottom: -500px;
  left: -200px;
}

.container1 {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}
.container1 .wrapper {
  padding: 40px;
  background-color: #fff;
  border-radius: 20px;
  width: 350px;
  z-index: 1;
}
.container1 .wrapper header {
  margin-bottom: 40px;
}
.container1 .wrapper header .logo {
  width: 70px;
  height: 70px;
  border-radius: 50px;
  background-color: rgb(255, 255, 255);
  display: flex;
  justify-content: center;
  align-items: center;
}
.container1 .wrapper header .logo img{
  width: 50px;
  height: 50px;

}
.container1 .wrapper header .logo span {
  font-size: 18px;
  color: #fff;
}
.container1 .wrapper header h1 {
  color: #6065D9;
  font-size: 35px;
  font-weight: 500;
  margin-bottom: 0;
  margin-top: 20px;
}
.container1 .wrapper header p {
  color: #6065D9;
  font-size: 18px;
  font-weight: 300;
  margin: 5px 0 0 0;
}
.container1 .wrapper .main-content input {
  border: none;
  display: block;
  width: 100%;
  height: 50px;
  margin: 15px 0;
  font-size: 18px;
  color: #999;
}
.container1 .wrapper .main-content input::placeholder {
  color: #999;
  font-size: 18px;
  font-weight: 300;
}
.container1 .wrapper .main-content input:focus {
  outline: none;
}
.container1 .wrapper .main-content .line {
  width: 100%;
  height: 2px;
  background-color: #99999955;
}
.container1 .wrapper .main-content button {
  background: linear-gradient(to right, #6065D9, #17D7FA);
  border: none;
  border-radius: 50px;
  font-size: 16px;
  letter-spacing: 7px;
  font-weight: 500;
  color: #fff;
  display: block;
  width: 100px;
  height: 40px;
  margin: 0 auto;
  outline: none;
  cursor: pointer;
}
.container1 .wrapper footer {
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  margin-top: 60px;
}
.container1 .wrapper footer p {
  margin: 0;
  font-weight: 100;
}
.container1 .wrapper footer p a {
  color: #6065D9;
  text-decoration: none;
}
.logWord{
  font-weight: 400;
  font-size: 15px;
  color: #6065D9;
  margin: 20px 0px;
}

@media (min-width: 320px) and (max-width: 768px) {
  .wrapper {
    margin: 0 10px !important;
    padding: 30px;
  }
  .wrapper header h1 {
    font-size: 30px;
  }
}
</style>
