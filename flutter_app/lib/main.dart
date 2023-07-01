import 'package:details/character_detail.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  final List<String> _characterImages = [
    "https://cdn.ome.lt/DBpJI5lrvsR7NqSk6U4-HZkhn74=/770x0/smart/uploads/conteudo/fotos/marvels_spider_man_DmZ5LLh.jpg",
    "https://disneyplusbrasil.com.br/wp-content/uploads/2021/04/Capitao-America-na-Lua.jpg",
    "https://conteudo.imguol.com.br/c/entretenimento/96/2020/08/07/iron-man-1596813808466_v2_615x300.jpg"
  ];

  MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: CharacterDetail(
        nameCharacter: 'Marvel',
        imagesUrl: _characterImages,
      ),
    );
  }
}
