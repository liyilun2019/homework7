# Video Player APP

### 1.播放本地的俞敏洪的视频：

<img src = "./gif4.gif" width=300/>

说明：这个播放是直接从raw里得到数据，我写的VideoPlayerFragment里如果URI为空就拿俞敏洪。然后这个支持横竖屏切换，并且自动适配屏幕大小。选项框勾选后就可以暂停以调节进度。我在切换屏幕时保存了进度，可以近似找回之前进度。

### 2.播放网络资源：

<img src = "./gif5.gif" width=300/>

说明：这是另外一个Activity，即VideoPlay，它被注册为**android.intent.action.VIEW**，然后它有一个data域声明它需要https协议的uri。在mainActivity里通过隐式调用传入网址：https://lf1-hscdn-tos.pstatp.com/obj/developer-baas/baas/tt7217xbo2wz3cem41/a8efa55c5c22de69_1560563154288.mp4 ，就可以播放一个互联网上的资源。