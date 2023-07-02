import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'character_detail.dart';
import 'host_constants.dart';

MethodChannel platform = MethodChannel(HostConstants.CHANNEL_ID);

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  MyAppState createState() => MyAppState();
}

class MyAppState extends State<MyApp> {
  String nameCharacter = "no name";
  String imagesUrl = "no_image";

  @override
  void initState() {
    super.initState();
    fetchDataFromPlatform();
  }

  Future<void> fetchDataFromPlatform() async {
    platform.setMethodCallHandler((call) async {
      if (call.method == HostConstants.DATA_PASS_METHOD) {
        final String data = call.arguments;
        final jData = jsonDecode(data);

        setState(() {
          nameCharacter = jData[HostConstants.DATA_CHARACTER_NAME];
          imagesUrl = jData[HostConstants.DATA_CHARACTER_IMAGE];
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: CharacterDetail(
        nameCharacter: nameCharacter,
        imagesUrl: [imagesUrl],
      ),
    );
  }
}
