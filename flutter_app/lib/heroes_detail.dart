import 'dart:async';

import 'package:flutter/material.dart';

class HeroesDetail extends StatefulWidget {
  @override
  State<HeroesDetail> createState() => _HeroesDetailState();
}

class _HeroesDetailState extends State<HeroesDetail>
    with SingleTickerProviderStateMixin {
  final List<String> _heroes = [
    "https://cdn.ome.lt/DBpJI5lrvsR7NqSk6U4-HZkhn74=/770x0/smart/uploads/conteudo/fotos/marvels_spider_man_DmZ5LLh.jpg",
    "https://disneyplusbrasil.com.br/wp-content/uploads/2021/04/Capitao-America-na-Lua.jpg",
    "https://conteudo.imguol.com.br/c/entretenimento/96/2020/08/07/iron-man-1596813808466_v2_615x300.jpg"
  ];

  late final TabController _controller;
  late final Timer _timer;

  final double _slider_height = 300;

  int _index = 0;

  @override
  void initState() {
    super.initState();
    _setupHeroesSlider();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Hero name"),
      ),
      body: _body(),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    _timer.cancel();
    super.dispose();
  }

  Container _body() {
    return Container(
      child: Column(
        children: [_heroesCarouselImages()],
      ),
    );
  }

  Container _heroesCarouselImages() {
    return Container(
      child: Stack(
        children: [
          Container(
            height: _slider_height,
            child: _heroImage(_heroes[_controller.index]),
          ),
          Container(
            height: _slider_height,
            padding: const EdgeInsets.only(bottom: 20.0),
            child: Align(
              alignment: FractionalOffset.bottomCenter,
              child: TabPageSelector(
                controller: _controller,
                color: Colors.black38,
                selectedColor: Colors.white30,
              ),
            ),
          )
        ],
      ),
    );
  }

  Image _heroImage(String url) {
    return Image.network(
      url,
      fit: BoxFit.cover,
    );
  }

  void _setupHeroesSlider() {
    _controller = TabController(
      length: _heroes.length,
      initialIndex: _index,
      vsync: this,
    );

    _timer = Timer.periodic(
      const Duration(milliseconds: 3000),
      (_) => _circulate(),
    );
  }

  void _circulate() {
    (_index != _heroes.length - 1) ? _index++ : _index = 0;
    _controller.animateTo(_index);
    setState(() {});
  }
}
