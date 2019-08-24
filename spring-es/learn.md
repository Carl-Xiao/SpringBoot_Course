## Elasticsearch 

> wocao,更新太快了，从我第一次接触到现在现在，版本从5开始到如今快升级到8了，用新版有些用法我得从头学着了
- 未来会取缔 type
- index type(废除) document
- 基本用法和说明参考官网文档是最好的，es的官网说明还是非常详细的
- 毕竟创始人一开始的目标只是想为老婆做一个小工具，无意之间开辟新大陆

### 创建索引
```
Put请求 localhost:9200/book/_mapping
参数
{
  "mappings":{
    "properties": {
      "word_count": {
        "type": "integer"
      },
      "author": {
        "type": "keyword"
      },
      "title": {
        "type": "text"
      }
    }
  }
}
```

### 插入document
```shell script
Put请求 localhost:9200/book/_mapping
参数
{
    
  "word_count":123,
   "author":"xiao",
  "title":"测试主题"
}
```


