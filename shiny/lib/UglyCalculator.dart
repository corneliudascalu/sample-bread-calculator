import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class UglyCalculator extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return UglyCalculatorState();
  }
}

class UglyCalculatorState extends State<UglyCalculator> {
  double _starterSliderValue = 0.05;
  double _waterSliderValue = 0.7;
  TextEditingController _flourController = TextEditingController();

  String _formatPercent(double value) {
    return (value * 100).toInt().toString() + "%";
  }

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      child: Padding(
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
                      CupertinoIcons.wand_stars_inverse,
                      size: 48.0,
                      color: CupertinoColors.activeBlue,
                    ),
                  ),
                  Expanded(
                    child: CupertinoTextField(
                      controller: _flourController,
                      placeholder: "Grams",
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
                    CupertinoIcons.share,
                    size: 48.0,
                    color: CupertinoColors.activeBlue,
                  ),
                  Expanded(
                      child: CupertinoSlider(
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
                    CupertinoIcons.drop,
                    size: 48.0,
                    color: CupertinoColors.activeBlue,
                  ),
                  Expanded(
                      child: CupertinoSlider(
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
              child: CupertinoButton(
                  onPressed: () {
                    return "";
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
}
