import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Bread Calculator',
      theme: ThemeData(
        primarySwatch: Colors.deepPurple,
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
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.end,
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(right: 24.0),
                    child: Icon(
                      Icons.grain,
                      size: 48.0,
                      color: Colors.deepPurple,
                    ),
                  ),
                  Expanded(
                    child: TextFormField(
                      decoration: InputDecoration(
                          labelText: "Grams",
                          border: OutlineInputBorder()),
                    ),
                  )
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    Icons.blur_on_rounded,
                    size: 48.0,
                    color: Colors.deepPurple,
                  ),
                  Expanded(
                      child: Slider(
                    onChanged: (value) {},
                    value: 5.0,
                    min: 0.0,
                    max: 20.0,
                  )),
                  Text(
                    "5%",
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  )
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    Icons.invert_colors,
                    size: 48.0,
                    color: Colors.deepPurple,
                  ),
                  Expanded(
                      child: Slider(
                    onChanged: (value) {},
                    value: 70.0,
                    min: 0.0,
                    max: 100.0,
                  )),
                  Text(
                    "70%",
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  )
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 24),
              child: ElevatedButton(
                  onPressed: () {},
                  child: Text(
                    "CALCULATE",
                  )),
            ),
          ],
        ),
      ),
    );
  }
}
