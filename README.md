# AptProcessor
1.打开所有源码，检查是否运行正常(要clean后，在运行)
2.同时打包api, annotation包（Compiler模块打包上传功能要关闭）
3.将api包改为Gradle(不是源码)依赖， annotation模块(要打开源码)打包上传功能要关闭，在打包Compiler包
4.最后都改为gradle依赖看项目是否正常(要clean后，在运行)
