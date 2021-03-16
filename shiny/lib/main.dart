import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Bread Calculator',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: BreadCalculator(title: 'Flutter Demo Home Page'),
    );
  }
}

class BreadCalculator extends StatefulWidget {
  BreadCalculator({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _BreadCalculatorState createState() => _BreadCalculatorState();
}

class _BreadCalculatorState extends State<BreadCalculator> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(onPressed: () {}, child: Text("Calculate")),
          ],
        ),
      ),
    );
  }
}
