# Clean-Architecture-Sample

Here's a simple Android app on which I've tried to implement a Clean Architecture as it should be "as the book says", using:

* Kotlin
* Dagger 2
* RxJava 2

So, a dependency rule is there, you can take a `data` layer and test it separately, without mocking a `Context`, only mocking data sources

## Dependency rule
![https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/](https://five.agency/wp-content/uploads/2016/11/Graph-1.png)

## Sequence diagram
![](https://i101.fastpic.ru/big/2018/0917/66/cb658b056efe63bfa7d9d224432a3e66.png)
