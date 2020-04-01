# AptProcessor
1.打开所有源码，检查是否运行正常(要clean后，在运行)
2.同时打开api和annotation的打包上传功能，Compiler打包上传功能要关闭，然后对api和annotation进行打包
3.将api和annotation的打包上传功能要关闭，Compiler打包上传功能要打开，
  然后Compiler模块里源码依赖的annotation要改为上面打完后包的依赖（com.github.EasyDevWork:AptProcessor:xxx),
  接着对Compiler进行打包
4.最后将所有的源码依赖改为刚打的gradle依赖，clean后，在运行是否正常
