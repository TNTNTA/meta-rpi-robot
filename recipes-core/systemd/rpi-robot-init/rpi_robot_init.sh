#!/bin/sh

export QT_QPA_PLATFORM=eglfs
export QT_QPA_EGLFS_NO_LIBINPUT=1
qml_luncher
