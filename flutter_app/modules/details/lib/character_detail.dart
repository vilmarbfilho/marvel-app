import 'dart:async';

import 'package:flutter/material.dart';

class CharacterDetail extends StatefulWidget {
  final String nameCharacter;
  final List<String> imagesUrl;

  const CharacterDetail({
    required this.nameCharacter,
    required this.imagesUrl,
    super.key,
  });

  @override
  State<CharacterDetail> createState() => _CharacterDetailState();
}

class _CharacterDetailState extends State<CharacterDetail>
    with SingleTickerProviderStateMixin {
  late final TabController _controller;
  late final Timer _timer;

  final double _sliderHeight = 300;

  int _index = 0;

  @override
  void initState() {
    super.initState();
    _setupCharacterSlider();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.nameCharacter),
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

  Column _body() {
    return Column(
      children: [_characterCarouselImages(), _characterDescription()],
    );
  }

  Stack _characterCarouselImages() {
    return Stack(
      children: [
        SizedBox(
          height: _sliderHeight,
          child: _characterImage(widget.imagesUrl[_controller.index]),
        ),
        Container(
          height: _sliderHeight,
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
    );
  }

  Image _characterImage(String url) {
    return Image.network(
      url,
      fit: BoxFit.cover,
    );
  }

  Flexible _characterDescription() {
    return const Flexible(
      child: Text(
        "Description",
        style: TextStyle(fontSize: 18),
        maxLines: 10,
      ),
    );
  }

  void _setupCharacterSlider() {
    _controller = TabController(
      length: widget.imagesUrl.length,
      initialIndex: _index,
      vsync: this,
    );

    _timer = Timer.periodic(
      const Duration(milliseconds: 3000),
      (_) => _circulate(),
    );
  }

  void _circulate() {
    (_index != widget.imagesUrl.length - 1) ? _index++ : _index = 0;
    _controller.animateTo(_index);
    setState(() {});
  }
}
