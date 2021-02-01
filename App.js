/**
 * rn小程序开发实例
 */

import React, {Component} from 'react';
import {Image, StyleSheet, Text, View, NativeModules, TouchableOpacity} from 'react-native';


export default class App extends Component<Props> {

    _updateApp = () => {
        const json = {
            mainComponentName: 'reactnative_multibundler4',
            scriptPath: 'android_4',
            SCRIPT_URL: 'http://192.168.174.26:8083/artifactory/rn_wgt/android_4.wgt',
        }
        NativeModules.commModule.updateApp(JSON.stringify(json))
    }


    _jumpToNextApp = () => {
        const json = {
            mainComponentName: 'reactnative_multibundler3',
            scriptPath: 'android_3',
            SCRIPT_URL: 'http://192.168.174.26:8083/artifactory/rn_wgt/android_3.wgt',
        }
        NativeModules.commModule.jumpToNextApp(JSON.stringify(json))
    }


    render() {
        return (
            <View style={styles.container}>
                <TouchableOpacity style={styles.button} onPress={this._updateApp}>
                    <Text>点击更新app</Text>
                </TouchableOpacity>

                <TouchableOpacity style={styles.button} onPress={this._jumpToNextApp}>
                    <Text>点击跳转到下一个app</Text>
                </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    button: {
        width: 200,
        height: 50,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'yellow',
        marginBottom:10,

    }
});
