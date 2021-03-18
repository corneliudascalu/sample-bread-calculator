import 'package:flutter/material.dart';
import 'package:shiny/calculator.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      routes: {
        "/home": (context) => BreadCalculator(),
      },
      title: 'Bread Calculator',
      theme: ThemeData(
        primarySwatch: Colors.deepPurple,
      ),
    );
  }
}
