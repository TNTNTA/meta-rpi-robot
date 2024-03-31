import QtQuick 2.12
import QtQuick.Window 2.12

Window {
    visible: true
    width: 800
    height: 480
    title: qsTr("Hello Rpi Robot")

    Image {
        id: imageDisplay
        anchors.centerIn: parent
        source: "qrc:/tt-robot_logo.jpeg"
        width: 800
        height: 480
        fillMode: Image.PreserveAspectFit
    }
}
