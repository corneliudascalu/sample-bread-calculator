import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

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
  double _starterSliderValue = 0.05;
  double _waterSliderValue = 0.7;
  TextEditingController _flourController = TextEditingController();

  String _formatPercent(double value) {
    return (value * 100).toInt().toString() + "%";
  }

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
                      controller: _flourController,
                      decoration: InputDecoration(
                          labelText: "Grams", border: OutlineInputBorder()),
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
                    onChanged: (value) {
                      setState(() {
                        _starterSliderValue = value;
                      });
                    },
                    value: _starterSliderValue,
                    min: 0.0,
                    max: 0.2,
                  )),
                  Text(
                    _formatPercent(_starterSliderValue),
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
                    onChanged: (value) {
                      setState(() {
                        _waterSliderValue = value;
                      });
                    },
                    value: _waterSliderValue,
                    min: 0.0,
                    max: 1.0,
                  )),
                  Text(
                    _formatPercent(_waterSliderValue),
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  )
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 24),
              child: ElevatedButton(
                  onPressed: () {
                    return _navigateToRecipe(context);
                  },
                  child: Text(
                    "CALCULATE",
                  )),
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _flourController.dispose();
    super.dispose();
  }

  static const platform = MethodChannel("bread.corneliudascalu.com/calculate");

  Future<void> _navigateToRecipe(BuildContext context) async {
    try {
      var parameters = {
        "flour": int.parse(_flourController.text),
        "water": _waterSliderValue,
        "starter": _starterSliderValue
      };
      await platform.invokeMethod("calculateBread", parameters);
      return Future.value(null);
    } on PlatformException catch (e) {
      print(e.message);
      return showDialog(
        context: context,
        builder: (context) => AlertDialog(
          content: Text(e.message),
        ),
      );
    }
  }
}
